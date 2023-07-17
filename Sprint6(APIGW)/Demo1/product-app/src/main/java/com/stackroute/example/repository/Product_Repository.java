package com.stackroute.example.repository;

import com.stackroute.example.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface Product_Repository extends MongoRepository<Product,String> {
@Query("{'productDetails.stock':{ $gte:1}}")
//@Query("{'category.stock':{$gte:1}}")
    public abstract List<Product> getProductByStock();
}
