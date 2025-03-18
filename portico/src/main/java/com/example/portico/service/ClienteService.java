package com.example.portico.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.portico.entidad.Cliente;

@Service
public interface  ClienteService {

    public Cliente SearchById(int id);

    public Collection<Cliente> SearchAll();

    public void deleteById(int id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);
    
    public Integer login(String username, String password);
}
