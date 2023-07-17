package com.stackroute.example.service;

import com.stackroute.example.domain.UserProduct;
import com.stackroute.example.domain.UserProduct;
import com.stackroute.example.exception.ProductAlreadyExistException;
import com.stackroute.example.exception.ProductNotFoundException;

import java.util.List;

public interface Product_Service {
    public abstract List<UserProduct> getAllProducts();
    public abstract UserProduct addProduct(UserProduct UserProduct) throws ProductAlreadyExistException;
    public abstract UserProduct updateProduct(UserProduct UserProduct);
    public abstract void deleteProduct(String id) throws ProductNotFoundException;

    public abstract List<UserProduct> getProductByStock();
    public abstract UserProduct getProductbyEmail(String email) throws ProductNotFoundException;
}
