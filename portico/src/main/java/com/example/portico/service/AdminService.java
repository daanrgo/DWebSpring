package com.example.portico.service;

import com.example.portico.entidad.Admin;

public interface AdminService {
    Admin findByUsername(String username);
}
