package com.ecommerce.store.service;

import com.ecommerce.store.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {

    public List<Product> findAll();

    public Product getProduct(int id);

    public void addProduct(Product prod);

    public void removeProduct(int id);
}
