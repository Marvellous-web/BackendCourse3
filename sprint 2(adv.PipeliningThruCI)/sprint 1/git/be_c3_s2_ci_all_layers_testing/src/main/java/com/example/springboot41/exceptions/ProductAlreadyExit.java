package com.example.springboot41.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Product already exist")
public class ProductAlreadyExit extends Exception {

}
