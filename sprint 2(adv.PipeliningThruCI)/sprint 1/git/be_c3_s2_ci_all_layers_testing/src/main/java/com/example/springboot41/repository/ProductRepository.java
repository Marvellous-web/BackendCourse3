package com.example.springboot41.repository;

import com.example.springboot41.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {

    @Query("{'Description.prStock':{$ne:0}}")
    public List<Product> getByStock();
}
