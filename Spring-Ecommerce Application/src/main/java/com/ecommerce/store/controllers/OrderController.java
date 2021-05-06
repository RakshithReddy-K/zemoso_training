package com.ecommerce.store.controllers;

import com.ecommerce.store.entity.Order;
import com.ecommerce.store.entity.Product;
import com.ecommerce.store.entity.User;
import com.ecommerce.store.service.OrderService;
import com.ecommerce.store.service.ProductService;
import com.ecommerce.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderservice;

    @Autowired
    private ProductService productservice;

    @Autowired
    private UserService userService;

    @GetMapping("/purchased")
    public String getAllOrders(Model model, @RequestParam("username") String name){


        List<Order> productList = orderservice.findByUserId(userService.getUserId(name));

        model.addAttribute("products", productList);

        return "products/products-purchased";
    }

    @GetMapping("/buy")
    public String buyProduct(@RequestParam("productId") int id, @RequestParam("username") String name) {

        Product prod = productservice.getProduct(id);

        Order order = new Order(prod.getName(), userService.getUserId(name), prod.getPrice());
        order.setId(0);
        orderservice.addOrder(order);

        return "redirect:/product/list";

    }

}
