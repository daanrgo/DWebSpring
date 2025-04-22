package com.example.portico.controlador;

import com.example.portico.dto.LoginDTO;
import com.example.portico.entidad.Admin;
import com.example.portico.entidad.Cliente;
import com.example.portico.entidad.Courier;
import com.example.portico.service.AdminService;
import com.example.portico.service.ClienteService;
import com.example.portico.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*") // Permitir peticiones desde Angular
public class LoginRestController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CourierService courierService;

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody com.example.portico.entidad.LoginForm loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        // Cliente
        Cliente cliente = clienteService.findByUsername(username);
        if (cliente != null && cliente.getPassword().equals(password)) {
            return ResponseEntity.ok(new LoginDTO(cliente.getId(), "cliente"));
        }

        // Courier
        Courier courier = courierService.findByUsername(username);
        if (courier != null && courier.getPassword().equals(password)) {
            return ResponseEntity.ok(new LoginDTO(courier.getId(), "courier"));
        }

        // Admin
        Admin admin = adminService.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return ResponseEntity.ok(new LoginDTO(admin.getId(), "admin"));
        }

        // No autenticado
        return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
    }
}
