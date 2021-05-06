package com.ecommerce.store.service;

import com.ecommerce.store.dao.UserRepository;
import com.ecommerce.store.entity.User;
import com.ecommerce.store.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public int getUserId(String username) {

        User user = userRepository.findByUserName(username);
        if(user==null) {
            throw new UserNotFoundException("NO USER FOUND WITH THIS NAME");
        }

        return user.getId();
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userRepository=" + userRepository +
                '}';
    }
}
