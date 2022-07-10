package com.norbry.recipeapp.service;

import com.norbry.recipeapp.dto.UserRegistrationDto;
import com.norbry.recipeapp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}