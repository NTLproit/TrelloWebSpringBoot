package com.ntl.trello.service;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;

@Component
public interface UserService {
    Object login(String email, String password);
    Object me(ServletRequest request);
}