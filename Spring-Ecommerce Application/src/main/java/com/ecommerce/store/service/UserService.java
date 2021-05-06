package com.ecommerce.store.service;

import com.ecommerce.store.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public int getUserId(String username);

}
