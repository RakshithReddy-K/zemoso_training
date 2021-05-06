package com.ecommerce.store.controllers;

import com.ecommerce.store.entity.Product;
import com.ecommerce.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/list")
    public String productsList (Model model){
        List<Product> productList = productService.findAll();

        model.addAttribute("products", productList);

        return "products/products-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormToAdd(Model model){
        Product prod = new Product();

        model.addAttribute("product", prod);

        return "products/product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "products/product-form";

        } else {
            productService.addProduct(product);

            return "redirect:/product/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int id){
        productService.removeProduct(id);

        return "redirect:/product/list";
    }

    @GetMapping("/update")
    public String updateProduct(@RequestParam("productId") int id,Model model) {

        Product prod = productService.getProduct(id);

        model.addAttribute("product", prod);

        return "products/product-form";
    }
}
