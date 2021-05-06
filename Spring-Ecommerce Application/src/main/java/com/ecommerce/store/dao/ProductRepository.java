package com.ecommerce.store.dao;

import com.ecommerce.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//jparepository consists of all the basic CRUD operations
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    public List<Product> findAll();
}
