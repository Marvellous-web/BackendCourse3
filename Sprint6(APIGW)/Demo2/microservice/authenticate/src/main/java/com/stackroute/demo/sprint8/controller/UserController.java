package com.stackroute.demo.sprint8.controller;

import com.stackroute.demo.sprint8.domain.UserModal;
import com.stackroute.demo.sprint8.service.SecurityTokenGenerator;
import com.stackroute.demo.sprint8.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


//http://localhost:9199/authentication-app/v1/register
@RestController @RequestMapping("/authentication-app/v1")
public class UserController {

    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;


    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserModal user)
    {
        user.setRole("Role_User");
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody UserModal user)
    {
        UserModal result=userService.checkLogin(user.getUser_id(),user.getPassword());
        if(result!=null)
        {
            Map<String,String> key=securityTokenGenerator.generateToken(result);
            return new ResponseEntity<>(key,HttpStatus.OK);

        }
        else
        {
            return new ResponseEntity<>("Login failed",HttpStatus.NOT_FOUND);

        }

    }





}
