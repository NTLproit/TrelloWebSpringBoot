package com.ntl.trello.service;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
    Object login(String email, String password);
}