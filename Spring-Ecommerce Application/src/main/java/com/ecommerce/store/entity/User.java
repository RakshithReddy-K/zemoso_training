package com.ecommerce.store.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public @Data class User{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="username")
    String userName;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="userid")
    private List<Order> orders;

    public User(){

    }
    public User(int id, String userName){
//        super(id);
        this.id = id;
        this.userName = userName;
    }

}
