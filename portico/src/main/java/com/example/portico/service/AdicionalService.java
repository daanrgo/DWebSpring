package com.example.portico.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.portico.entidad.Adicional;



public interface AdicionalService {

    
    public Adicional SearchById(int id);

    public Collection<Adicional> SearchAll();

    public void deleteById(int id);

    public void update(Adicional adicional);

    public void add(Adicional adicional);

}
