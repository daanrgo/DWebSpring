package com.example.portico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.portico.entidad.Admin;
import com.example.portico.repositorio.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepo;

    @Override
    public Admin findByUsername(String username) {
        return adminRepo.findByUsername(username);
    }
}
