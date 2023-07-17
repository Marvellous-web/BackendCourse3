package com.example.springboot41;

import com.example.springboot41.domain.Description;
import com.example.springboot41.domain.Product;
import com.example.springboot41.exceptions.ProductAlreadyExit;
import com.example.springboot41.exceptions.ProductNotFound;
import com.example.springboot41.repository.ProductRepository;
import com.example.springboot41.services.ProductService;
import com.example.springboot41.services.ProductServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServicetest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;
    private Description description;

    @BeforeEach
    public  void setup(){
        product=new Product("P005","SAMSUNG",50000,description);
        description=new Description("tv",10,4);
    }
    @AfterEach
    public void clean(){
        product=null;
        description=null;
        productRepository.deleteAll();
    }
    @Test //addProduct() :: success
    public void addProductSuccess() throws ProductAlreadyExit {
        when(productRepository.findById(product.getPrCode())).thenReturn(Optional.ofNullable(null));
        when(productRepository.insert(product)).thenReturn(product);
        assertEquals(product,productService.addProduct(product));
        verify(productRepository,times(1)).findById(product.getPrCode());
        verify(productRepository,times(1)).insert(product);
    }
    @Test //addProduct() :: failure
    public void addProductFailure() throws ProductAlreadyExit{
        when(productRepository.findById(product.getPrCode())).thenReturn(Optional.ofNullable(product));
        assertThrows(ProductAlreadyExit.class,()->productService.addProduct(product));

        verify(productRepository,times(1)).findById(product.getPrCode());
        verify(productRepository,times(0)).insert(product);
    }

    @Test //deleteCustomer :: success
    public void deleteProductByCodeSuccess() throws ProductNotFound {
        when(productRepository.findById(product.getPrCode())).thenReturn(Optional.ofNullable(product));
       boolean result = productService.deleteProductByCode(product.getPrCode());
       assertEquals(true,result);
//
//        assertEquals(product,productService.deleteProductByCode(););
        verify(productRepository,times(1)).findById(product.getPrCode());
        verify(productRepository,times(1)).deleteById(product.getPrCode());
    }

    @Test
    public void deleteProductByIdFailure() throws ProductNotFound {
        when(productRepository.findById(product.getPrCode())).thenReturn(Optional.ofNullable(null));
//        boolean result=productService.deleteProductByCode(product.getPrCode());
//        assertEquals(false,result);
      assertThrows(ProductNotFound.class,()->productService.deleteProductByCode(product.getPrCode()));
        verify(productRepository,times(1)).findById(product.getPrCode());
        verify(productRepository,times(0)).deleteById(product.getPrCode());

    }


}

