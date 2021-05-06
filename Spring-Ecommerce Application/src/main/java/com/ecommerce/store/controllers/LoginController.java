package com.ecommerce.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class LoginController {

    @GetMapping("/")
    public String home(){
        return "dashboard";
    }
    
    @GetMapping("/showMyLoginPage")
    public String login()
    {
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String accessDeniedPage()
    {
        return "access-denied";
    }

}
