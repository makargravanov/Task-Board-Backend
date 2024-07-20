package com.example.taskboardbackend.Core;

import com.example.taskboardbackend.Core.Domain.CustomJWT.JWTValidator;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JWTFilter implements Filter {
    private final JWTValidator jwtValidator;

    public JWTFilter(JWTValidator jwtValidator) {
        this.jwtValidator = jwtValidator;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String jwt = null;
        if (httpRequest.getCookies() != null) {
            for (Cookie cookie : httpRequest.getCookies()) {
                if ("jwt".equals(cookie.getName())) {
                    jwt = cookie.getValue();
                    break;
                }
            }
        }

        if (jwtValidator.validate(jwt)) {
            // JWT валиден, продолжаем цепочку фильтров
            chain.doFilter(request, response);
        } else {
            // JWT не валиден, возвращаем ошибку
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
