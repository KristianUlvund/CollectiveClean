package com.microservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bruker on 24.04.2017.
 */
@Controller
public class GroupController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
