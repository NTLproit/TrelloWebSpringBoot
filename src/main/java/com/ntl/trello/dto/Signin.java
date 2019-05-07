package com.ntl.trello.dto;

import com.ntl.trello.entity.Role;

import java.util.List;

public class Signin {
    private String token;
    private Long users_id;
    private String username;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Signin(String token, Long users_id, String username, List<Role> roles) {
        this.token = token;
        this.users_id = users_id;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public Long getUsers_id() {
        return users_id;
    }
}
