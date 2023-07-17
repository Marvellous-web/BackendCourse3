package com.example.springboot41.controllers;

import com.example.springboot41.domain.Product;
import com.example.springboot41.exceptions.ProductAlreadyExit;
import com.example.springboot41.exceptions.ProductNotFound;
import com.example.springboot41.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/productapp/v1")
@RestController
public class ProductCon {

    @Autowired
    private ProductService productService;
//http://localhost:9999/productapp/v1/product
    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts(){
        return  new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    //http://localhost:9999/productapp/v1/product
//    {
//        "prCode": "p0003",
//            "prName": "SAMSUNG",
//            "prPrice": 20000,
//            "description": {
//        "prType": "TV",
//                "prStock": 10,
//                "prRating": 4
//    }
//    }
    //@@PostMapping("/product")
    @PostMapping("/register-product")
    public ResponseEntity<?> addProduct(@RequestBody Product product)throws ProductAlreadyExit {
        try{
            return new ResponseEntity<>(productService.addProduct(product),HttpStatus.OK);
        }catch (ProductAlreadyExit ex){
            throw new ProductAlreadyExit();
        }
        //http://localhost:9999/productapp/v1/product
    }
    @PutMapping("/product")
    public ResponseEntity<?> updatePrice(@RequestBody Product prd){
        Product result = productService.updatePrice(prd);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    //http://localhost:9999/productapp/v1/product-delete/{productCode}
    @DeleteMapping("/product-delete/{productCode}")
public  ResponseEntity<?> deletProduct(@PathVariable String productCode) throws ProductNotFound{
        try {
            productService.deleteProductByCode(productCode);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }catch (ProductNotFound EX){
            throw new ProductNotFound();
        }
    }
    //http://localhost:9999/productapp/v1/productby-code/
    @GetMapping("/productby-code/{productCode}")
    public ResponseEntity<?>getProductByCode(@PathVariable String productCode)throws ProductNotFound {
        try {
            return new ResponseEntity<>(productService.getProductByCode(productCode), HttpStatus.OK);
        } catch (ProductNotFound ex) {
            throw new ProductNotFound();
        }
    }
    //http://localhost:9999/productapp/v1/productby-stock
    @GetMapping("/productby-stock")
    public ResponseEntity<?> getAllProductsareinstock(){
        return  new ResponseEntity<>(productService.getProductByStock(), HttpStatus.OK);
    }
}
