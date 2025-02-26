package com.example.portico.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.entidad.Comida;
import com.example.portico.repositorio.ComidaRepository;

@Service
public class ComidaServiceImpl implements ComidaService {
 
    @Autowired
    ComidaRepository repo;

    @Override
    public Comida SearchById(int id) {

        return repo.findById(id);
    }

    @Override
    public Collection<Comida> SearchAll() {

        return repo.findAll();
    }
}
