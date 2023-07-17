package com.stackroute.demo.sprint8.service;

import com.stackroute.demo.sprint8.domain.UserModal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(UserModal userModal) {
        Map<String,String> result=new HashMap<>();
        Map<String,Object> data=new HashMap<>();
        data.put("userObject",userModal);
//        Date date=new Date(date.getTime() +  60000);

        String jwtToken= Jwts.builder().setClaims(data).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512,"mysecurekey").compact();
        result.put("token",jwtToken);
        result.put("message","user successfully Logged in");

        return result;
    }
}
