package com.stackroute.example.service;

import com.stackroute.example.domain.Product;
import com.stackroute.example.exception.ProductAlreadyExistException;
import com.stackroute.example.exception.ProductNotFoundException;

import java.util.List;

public interface Product_Service {
    public abstract List<Product> getAllProducts();
    public abstract Product addProduct(Product product) throws ProductAlreadyExistException;
    public abstract Product updateProduct(Product product);
    public abstract void deleteProduct(String id) throws ProductNotFoundException;

    public abstract List<Product> getProductByStock();
}
