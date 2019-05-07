package com.ntl.trello.service;

import com.ntl.trello.entity.Users;
import org.springframework.stereotype.Component;

@Component
public interface JwtService {
    String generateToken(Users user);
    Users getUserByToken(String token);
}
