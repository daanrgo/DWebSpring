package com.example.portico.service;

import java.util.Collection;

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

        return repo.findById(id);
    }

    @Override
    public Collection<Cliente> SearchAll() {

        return repo.findAll();
    }

    @Override
    public void deleteById(int id){
        repo.deleteById(id);
    }

    @Override
    public void update(Cliente cliente){
        repo.update(cliente);
    }

    @Override    
    public void add(Cliente cliente){
        repo.add(cliente);
    }

    @Override
    public Boolean login(String username, String password) {

        Boolean autenticado = false;
        Cliente cliente = repo.findByUsername(username);

        if(cliente!=null) {

            if(cliente.getPassword().equals(password)) {
                
                autenticado = true;
            }
        }
        return autenticado;
    }
}
