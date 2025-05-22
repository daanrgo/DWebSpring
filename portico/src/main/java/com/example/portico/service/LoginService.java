// src/main/java/com/example/portico/servicio/LoginService.java

package com.example.portico.service;

import com.example.portico.entidad.UserEntity;
import com.example.portico.repositorio.UserRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity buscarPorUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public UserEntity registrarUsuario(UserEntity user) {
        return userRepository.save(user);
    }

    public boolean validarCredenciales(String username, String password) {
        UserEntity user = userRepository.findByUsername(username).orElse(null);
        return user != null && user.getPassword().equals(password);
    }
}        
