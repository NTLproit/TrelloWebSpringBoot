package com.ntl.trello.controller;

import com.ntl.trello.dto.Signin;
import com.ntl.trello.entity.Project;
import com.ntl.trello.entity.Users;
import com.ntl.trello.service.ProjectService;
import com.ntl.trello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@ComponentScan(basePackages = "com.ntl.trello")
public class Controller {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserService service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST, consumes ={MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Object login(@Valid @RequestBody Users user, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();
        Signin singin = (Signin) service.login(username, password);
        if(singin != null){
            session.setAttribute("signin", singin);
        }
        return singin;
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public List<Project> getAllProject(HttpSession session){
        Signin signin = (Signin) session.getAttribute("signin");
        List<Project> projects = projectService.getAllProjectByUserId(signin.getUsers_id());
        return projects;
    }
}


