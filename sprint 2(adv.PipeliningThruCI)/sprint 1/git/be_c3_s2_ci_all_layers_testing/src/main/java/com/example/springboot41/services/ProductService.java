package com.example.springboot41.services;

import com.example.springboot41.domain.Product;
import com.example.springboot41.exceptions.ProductAlreadyExit;
import com.example.springboot41.exceptions.ProductNotFound;

import java.util.List;

public interface ProductService {
    public abstract List<Product> getAllProducts();
    public abstract Product addProduct(Product product)throws ProductAlreadyExit;
    public abstract List<Product> getProductByStock();
    public abstract Product getProductByCode(String productCode)throws ProductNotFound;
    public abstract Product updatePrice(Product productPrice);
    public abstract boolean deleteProductByCode(String productCode) throws ProductNotFound;
}
