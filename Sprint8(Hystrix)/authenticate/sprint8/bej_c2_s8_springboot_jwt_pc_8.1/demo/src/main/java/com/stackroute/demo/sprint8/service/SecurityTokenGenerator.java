package com.stackroute.demo.sprint8.service;

import com.stackroute.demo.sprint8.domain.UserModal;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String ,String> generateToken(UserModal userModal);



}
