package com.example.portico.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.portico.entidad.Operator;

@Service
public interface  OperatorService {

    public Operator SearchById(int id);

    public Collection<Operator> SearchAll();

    public void deleteById(int id);

    public void update(Operator cliente);

    public void add(Operator cliente);
    
    public Boolean login(String username, String password);

    public Operator findByUsername(String username);

}
