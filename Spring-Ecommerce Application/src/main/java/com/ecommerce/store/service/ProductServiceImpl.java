package com.ecommerce.store.service;

import com.ecommerce.store.dao.ProductRepository;
import com.ecommerce.store.entity.Product;
import com.ecommerce.store.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public String toString() {
        return "ProductServiceImpl{" +
                "productRepository=" + productRepository +
                '}';
    }

    @Override
    public Product getProduct(int id) {
        //optional object which may or may not contain a non-null value
        Optional<Product> prodTemp = productRepository.findById(id);
        if(!prodTemp.isPresent()){
            throw new ProductNotFoundException("No Product Found with this ID");
        }
        return prodTemp.get();
    }

    @Override
    public void addProduct(Product prod) {
        productRepository.save(prod);
    }

    @Override
    public void removeProduct(int id) {
        productRepository.deleteById(id);
    }
}
