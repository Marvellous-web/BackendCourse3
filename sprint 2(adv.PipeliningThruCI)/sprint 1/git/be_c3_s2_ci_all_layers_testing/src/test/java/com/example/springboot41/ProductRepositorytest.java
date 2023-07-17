package com.example.springboot41;

import com.example.springboot41.domain.Description;
import com.example.springboot41.domain.Product;
import com.example.springboot41.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class ProductRepositorytest {
    @Autowired
    private ProductRepository productRepository;

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
    @Test
    public void getAllProducts(){
        productRepository.insert(product);
        product.setPrCode(("P0002"));
        productRepository.insert(product);
        List<Product> products=productRepository.findAll();
        assertEquals(2,products.size());
    }
    @Test
    public void givenProductDetailsToSave(){
        productRepository.insert(product);
        Product product1=productRepository.findById(product.getPrCode()).get();
        System.out.println((product1.equals(product)));
        assertEquals(product1,product);
    }
    @Test
    public void productToDelete(){
        productRepository.insert(product);
        productRepository.deleteById(product.getPrCode());
        assertEquals(Optional.empty(),productRepository.findById((product.getPrCode())));
    }

}
