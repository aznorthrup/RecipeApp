package com.norbry.recipeapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping(path = "/")
    public String showHomePage(Model model) {
        logger.info("Displayed home page");
        return "home.html";
    }

    @GetMapping("/login")
    public String login() {
        logger.info("Displayed login page");
        return "login.html";
    }

    @GetMapping("/error")
    public String error() {
        logger.info("Displayed error page");
        return "error.html";
    }
    
    @GetMapping("/about")
    public String about() {
    	logger.info("Displayed about page");
    	return "about.html";
    }

}