package com.stackroute.demo.sprint8.service;

import com.stackroute.demo.sprint8.domain.UserModal;
import com.stackroute.demo.sprint8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModal addUser(UserModal userModal) {
        return userRepository.save(userModal);
    }

    @Override
    public UserModal checkLogin(int id, String pwd) {

        if (userRepository.findById(id).isPresent()) {
            UserModal result = userRepository.findById(id).get();
            if (result.getPassword().equals(pwd)) {
                result.setPassword("");//setting the password to null because data post during login due to that password also post and visible thatswhy we set the password to null
                return result;
            } else {
                return null;
            }

        } else

            return null;
    }
}
