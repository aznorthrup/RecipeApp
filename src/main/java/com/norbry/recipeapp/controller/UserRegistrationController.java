package com.norbry.recipeapp.controller;

import javax.validation.Valid;

import com.norbry.recipeapp.dto.UserRegistrationDto;
import com.norbry.recipeapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {

    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(LoggerController.class);

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        logger.info("Displayed registration page");
        model.addAttribute("user", new UserRegistrationDto());
        return "registration.html";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid UserRegistrationDto registrationDto, BindingResult bind) {
        if (bind.hasErrors()){
            logger.info("Failed to save a user");
            return "redirect:/registration?error";
        }else {
            userService.save(registrationDto);
            logger.info("Saved new user with email of " + registrationDto.getEmail());
            return "redirect:/registration?success";
        }
    }

}
