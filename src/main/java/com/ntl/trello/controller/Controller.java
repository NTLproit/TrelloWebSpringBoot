package com.ntl.trello.controller;

import com.ntl.trello.dto.Signin;
import com.ntl.trello.entity.Users;
import com.ntl.trello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@ComponentScan(basePackages = "com.ntl.trello")
public class Controller {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserService service;

    @RequestMapping(value = "/signin", method = RequestMethod.POST, consumes ={MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Object login(@Valid @RequestBody Users user){
        String username = user.getUsername();
        String password = user.getPassword();
        Signin singin = (Signin) service.login(username, password);
        return singin;
    }
}

