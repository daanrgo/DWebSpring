package com.example.portico.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.entidad.Courier;
import com.example.portico.repositorio.ClienteRepository;
import com.example.portico.repositorio.CourierRepository;

@Service
public class CourierServiceImpl implements CourierService {
    

    @Autowired
    CourierRepository repo;

    @Override
    public Courier SearchById(int id) {

        Optional <Courier> optionalCliente = repo.findById(id);
        if(optionalCliente.isPresent()) {

            return optionalCliente.get();
        }

        else {

            return null;
        }
    }

    @Override
    public Collection<Courier> SearchAll() {

        return repo.findAll();
    }

    @Override
    public void deleteById(int id){
        repo.deleteById(id);
    }

    @Override
    public void update(Courier cliente){
        repo.findById(cliente.getId()).ifPresent(elCliente -> {

            repo.save(cliente);
        });
    }

    @Override    
    public void add(Courier cliente){
        repo.save(cliente);
    }

    @Override
    public Boolean login(String username, String password) {

        Boolean autenticado = false;
        Courier cliente = repo.findByUsername(username);

        if(cliente!=null) {

            if(cliente.getPassword().equals(password)) {
                
                autenticado = true;
            }
        }
        return autenticado;
    }
}
