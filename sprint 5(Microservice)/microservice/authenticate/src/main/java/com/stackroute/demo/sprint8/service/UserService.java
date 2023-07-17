package com.stackroute.demo.sprint8.service;

import com.stackroute.demo.sprint8.domain.UserModal;

public interface UserService  {
    public abstract UserModal addUser(UserModal userModal);
    public abstract UserModal checkLogin(int id,String pwd);



}
