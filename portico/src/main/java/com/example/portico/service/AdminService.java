package com.example.portico.service;

import com.example.portico.entidad.Admin;
import java.util.List;

public interface AdminService {
    Admin findByUsername(String username);
    List<Admin> findAll(); 
}
