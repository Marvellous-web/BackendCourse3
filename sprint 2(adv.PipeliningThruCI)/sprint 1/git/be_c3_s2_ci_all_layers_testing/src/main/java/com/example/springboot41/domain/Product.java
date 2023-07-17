package com.example.springboot41.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Product {
@Id
    private String prCode;
    private String prName;
    private int prPrice;
    private Description description;
}