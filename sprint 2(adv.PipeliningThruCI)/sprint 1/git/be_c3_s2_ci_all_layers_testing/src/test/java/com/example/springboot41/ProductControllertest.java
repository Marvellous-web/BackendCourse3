package com.example.springboot41;

import com.example.springboot41.controllers.ProductCon;
import com.example.springboot41.domain.Description;
import com.example.springboot41.domain.Product;
import com.example.springboot41.exceptions.ProductAlreadyExit;
import com.example.springboot41.services.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProductControllertest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ProductServiceImpl productService;
    @InjectMocks
    private ProductCon productCon;

    private Product product;
    private Description description;

    @BeforeEach
    public  void setup(){
        product=new Product("P005","SAMSUNG",50000,description);
        description=new Description("tv",10,4);
        mockMvc= MockMvcBuilders.standaloneSetup(productCon).build();
    }
    @AfterEach
    public void clean(){
        product=null;
        description=null;
    }
    @Test
    public void addProductSuccess() throws   Exception {
        when(productService.addProduct(product)).thenReturn(product);
        mockMvc.perform(post("/productapp/v1/product").contentType(MediaType.APPLICATION_JSON).content(convertToJson(product)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(productService, times(1)).addProduct(product);

    }
    @Test
    public void addProductFailure() throws Exception{
        when(productService.addProduct(product)).thenThrow(ProductAlreadyExit.class);
        mockMvc.perform(post("/productapp/v1/product").contentType(MediaType.APPLICATION_JSON).content(convertToJson(product)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(productService,times(1)).addProduct(product);
    }

    private static String convertToJson(final Object object) {
        String result="";
        try{
            ObjectMapper mapper=new ObjectMapper();
            result=mapper.writeValueAsString(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
