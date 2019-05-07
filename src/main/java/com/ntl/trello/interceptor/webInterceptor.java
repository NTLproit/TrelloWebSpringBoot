package com.ntl.trello.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class webInterceptor implements HandlerInterceptor {
    private String KEY = "secret";

    private String TOKEN_HEADER = "Authorization";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String token = request.getHeader(TOKEN_HEADER).replace("Bearer ", "");
            if (token == null || token.trim().length() == 0) {
                return false;
            }
            Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            response.getWriter().print("Token is invalid!");
            return false;
        }
    }
}
