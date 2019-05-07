package com.ntl.trello.service;

import com.ntl.trello.entity.Users;
import com.ntl.trello.repository.UsersRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImp implements JwtService{
    private static final String key = "secret";

    @Autowired
    private UsersRepository repository;

    @Override
    public String generateToken(Users user) {
        long nowMillis = System.currentTimeMillis();
        Date date = new Date(nowMillis * 10);
        String token;
        token = Jwts.builder()
                .setSubject("user")
                .setExpiration(date)
                .claim("id", user.getId())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return token;
    }


    @Override
    public Users getUserByToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
        int id = (int) claims.get("id");
        Users user = repository.findById(id);
        return user;
    }
}
