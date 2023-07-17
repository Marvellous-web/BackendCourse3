package com.example.springboot41.services;

import com.example.springboot41.domain.Product;
import com.example.springboot41.exceptions.ProductAlreadyExit;
import com.example.springboot41.exceptions.ProductNotFound;
import com.example.springboot41.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) throws ProductAlreadyExit {
        if(productRepository.findById(product.getPrCode()).isPresent()){
            throw new ProductAlreadyExit();
        }
        else {
            return productRepository.insert(product);
        }
    }

    @Override
    public List<Product> getProductByStock() {
         return productRepository.getByStock();
    }

    @Override
    public Product getProductByCode(String productCode) throws ProductNotFound {
        if(productRepository.findById(productCode).isPresent()){
            return productRepository.findById(productCode).get();
        }else {
            throw  new ProductNotFound();
        }
    }

    @Override
    public Product updatePrice(Product productPrice) {
        return productRepository.save(productPrice);
    }

    @Override
    public boolean deleteProductByCode(String productCode) throws ProductNotFound{
        boolean a=false;
if(productRepository.findById(productCode).isPresent()){
     productRepository.deleteById(productCode);
     a=true;
}else {
    throw  new ProductNotFound();
}
return a;
    }
}
