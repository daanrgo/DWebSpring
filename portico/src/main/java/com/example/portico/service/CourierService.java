package com.example.portico.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.portico.entidad.Courier;

@Service
public interface  CourierService {

    public Courier SearchById(int id);

    public Collection<Courier> SearchAll();

    public void deleteById(int id);

    public void update(Courier cliente);

    public void add(Courier cliente);
    
    public Boolean login(String username, String password);
}
