package com.stackroute.example.service;

import com.stackroute.example.domain.Product;
import com.stackroute.example.exception.ProductAlreadyExistException;
import com.stackroute.example.exception.ProductNotFoundException;
import com.stackroute.example.repository.Product_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductServiceImpl implements Product_Service{
    @Autowired
    private Product_Repository product_repository;
    @Override
    public List<Product> getAllProducts() {
        return product_repository.findAll();
    }

    @Override
    public Product addProduct(Product product) throws ProductAlreadyExistException {

        if(product_repository.findById(product.getId()).isPresent())
        {
            throw new ProductAlreadyExistException();

        }
        else return product_repository.insert(product);

    }

    @Override
    public Product updateProduct(Product product) {
        return product_repository.save(product);
    }

    @Override
    public void deleteProduct(String id) throws ProductNotFoundException {
        if(product_repository.findById(id).isPresent())
        {
            product_repository.deleteById(id);
        }
        else
        {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public List<Product> getProductByStock()  {
        return product_repository.getProductByStock();
    }
}
