package com.ntl.trello.service;

import com.ntl.trello.dto.Signin;
import com.ntl.trello.entity.Role;
import com.ntl.trello.entity.Users;
import com.ntl.trello.repository.RoleRepository;
import com.ntl.trello.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JwtService service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Object login(String email, String password) {
        Users user = usersRepository.findByUsername(email);
        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            String token = service.generateToken(user);
            List<Role> roles = roleRepository.findAllRoleByUserId(user.getId());
            Signin singin = new Signin(token,user.getId(), user.getUsername(), roles);
            return singin;
        }
        return null;
    }
    @Override
    public Object me(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization").replace("Bearer ", "");
        Users user = service.getUserByToken(token);
        return user;
    }
}
