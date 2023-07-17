package com.example.springboot41.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Description {
    private String prType;
    private int prStock;
    private float prRating;
}
