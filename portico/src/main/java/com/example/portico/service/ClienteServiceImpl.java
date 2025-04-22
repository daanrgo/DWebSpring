package com.example.portico.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.entidad.Cliente;
import com.example.portico.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repo;

    @Override
    public Cliente SearchById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Collection<Cliente> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        repo.findById(cliente.getId()).ifPresent(c -> repo.save(cliente));
    }

    @Override
    public void add(Cliente cliente) {
        repo.save(cliente);
    }

    @Override
    public Cliente autenticar(String username, String password) {
        Cliente cliente = repo.findByUsername(username);
        if (cliente != null && cliente.getPassword().equals(password)) {
            return cliente;
        }
        return null;
    }
    @Override
    public Cliente findByUsername(String username) {
        return repo.findByUsername(username);
    }

}
