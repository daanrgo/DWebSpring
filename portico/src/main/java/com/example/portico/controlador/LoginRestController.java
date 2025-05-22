// src/main/java/com/example/portico/controlador/LoginRestController.java

package com.example.portico.controlador;

import com.example.portico.dto.JwtResponseDTO;
import com.example.portico.entidad.LoginForm;
import com.example.portico.entidad.UserEntity;
import com.example.portico.service.LoginService;
import com.example.portico.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginRestController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
        UserEntity user = loginService.buscarPorUsername(loginForm.getUsername());

        if (user == null || !user.getPassword().equals(loginForm.getPassword())) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }

        String token = jwtUtil.generateToken(user);
        String role = user.getFirstRoleName();
        Integer id = user.getId();

        JwtResponseDTO response = new JwtResponseDTO(id, role, token);
        return ResponseEntity.ok(response);
    }
}
