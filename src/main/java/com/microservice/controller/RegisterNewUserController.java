package com.microservice.controller;

import com.microservice.domain.User;
import com.microservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Bruker on 24.04.2017.
 */
@Controller
public class RegisterNewUserController extends WebMvcConfigurerAdapter {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    //add user
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                           Model model) {
        if(username.isEmpty() || password.isEmpty()) {
            return "error";
        }
        userRepo.createUser(username, password);
        List<User> users = this.userRepo.findAll();
        model.addAttribute( "users", users );
        return "login";
    }
}
