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

        Optional <Cliente> optionalCliente = repo.findById(id);
        if(optionalCliente.isPresent()) {

            return optionalCliente.get();
        }

        else {

            return null;
        }
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
        repo.findById(cliente.getId()).ifPresent(elCliente -> {

            repo.save(cliente);
        });
    }

    @Override    
    public void add(Cliente cliente){
        repo.save(cliente);
    }

    @Override
    public Integer login(String username, String password) {

        Integer id_autenticado = -1;
        Cliente cliente = repo.findByUsername(username);

        if(cliente!=null) {

            if(cliente.getPassword().equals(password)) {
                
                id_autenticado = cliente.getId();
            }
        }
        return id_autenticado;
    }
}
