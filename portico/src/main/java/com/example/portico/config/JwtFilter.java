// src/main/java/com/example/portico/config/JwtFilter.java

package com.example.portico.config;

import com.example.portico.util.JwtUtil;
import com.example.portico.entidad.UserEntity;
import com.example.portico.repositorio.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String username = jwtUtil.getUsernameFromToken(token);

            if (username != null) {
                Optional<UserEntity> userOptional = userRepository.findByUsername(username);
                if (userOptional.isPresent()) {
                    UserEntity user = userOptional.get();
                    if (jwtUtil.validateToken(token, user)) {
                        // Aquí podrías añadir lógica de seguridad si decides integrarte con Spring Security
                        request.setAttribute("user", user);
                    }
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
