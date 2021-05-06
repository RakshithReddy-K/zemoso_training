package com.ecommerce.store.service;

import com.ecommerce.store.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public List<Order> findAll();

    public List<Order> findByUserId(int id);

    public void addOrder(Order order);

}
