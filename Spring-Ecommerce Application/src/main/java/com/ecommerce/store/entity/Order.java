package com.ecommerce.store.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="orders")
public @Data class Order{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="productname")
    String productName;

    @Column(name="userid")
    int userId;

    @Column(name="price")
    String price;

    public Order(String productName, int userId, String price) {

        this.productName = productName;
        this.userId = userId;
//        this.userName = userName;
        this.price = price;
    }

    public Order() {

    }


}
