package com.example.portico.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.portico.entidad.Comida;

@Service
public interface ComidaService {
    
    public Comida SearchById(int id);

    public Collection<Comida> SearchAll();
}
