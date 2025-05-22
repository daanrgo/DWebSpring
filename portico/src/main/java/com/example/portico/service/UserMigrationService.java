// src/main/java/com/example/portico/service/UserMigrationService.java

package com.example.portico.service;

import com.example.portico.entidad.*;
import com.example.portico.repositorio.UserRepository;
import com.example.portico.repositorio.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMigrationService implements CommandLineRunner {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CourierService courierService;
    @Autowired
    private OperatorService operatorService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        if (!userRepository.findAll().isEmpty()) return; // ya migrado

        createRoleIfMissing("cliente");
        createRoleIfMissing("admin");
        createRoleIfMissing("courier");
        createRoleIfMissing("operador");

        for (Cliente c : clienteService.SearchAll()) {
            createUserEntity(c.getUsername(), c.getPassword(), "cliente");
        }
        Admin admin = adminService.findByUsername("admin");
        if (admin != null) {
            createUserEntity(admin.getUsername(), admin.getPassword(), "admin");
        }
        for (Courier c : courierService.searchAll()) {
            createUserEntity(c.getUsername(), c.getPassword(), "courier");
        }
        for (Operator o : operatorService.SearchAll()) {
            createUserEntity(o.getUsername(), o.getPassword(), "operador");
        }
    }

    private void createUserEntity(String username, String password, String roleName) {
        if (userRepository.findByUsername(username).isEmpty()) {
            Role role = roleRepository.findByName(roleName).orElseThrow();
            UserEntity user = UserEntity.builder()
                    .username(username)
                    .password(password)
                    .roles(List.of(role))
                    .build();
            userRepository.save(user);
        }
    }

    private void createRoleIfMissing(String roleName) {
        roleRepository.findByName(roleName).orElseGet(() -> {
            Role role = new Role();
            role.setName(roleName);
            return roleRepository.save(role);
        });
    }
}
