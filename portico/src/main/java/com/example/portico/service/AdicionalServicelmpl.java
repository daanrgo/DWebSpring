package com.example.portico.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.portico.entidad.Comida;
import com.example.portico.repositorio.AdicionalRepository;
import com.example.portico.repositorio.ComidaRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.entidad.Adicional;
import com.example.portico.repositorio.AdicionalRepository;

@Service
public class AdicionalServicelmpl implements AdicionalService {
    
    @Autowired
    AdicionalRepository repo;

    @Override
    public Adicional SearchById(int id) {

        return repo.findById(id);
    }

    @Override
    public Collection<Adicional> SearchAll() {

        return repo.findAll();
    }

    @Override
    public void deleteById(int id){
        repo.deleteById(id);
    }

    @Override
    public void update(Adicional adicional){
        repo.update(adicional);
    }

    @Override    
    public void add(Adicional adicional){
        repo.add(adicional);
    }
}
