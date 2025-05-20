package com.example.portico.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.entidad.Operator;
import com.example.portico.repositorio.OperatorRepository;

@Service
public class OperatorServiceImpl implements OperatorService {
    

    @Autowired
    OperatorRepository repo;

    @Override
    public Operator SearchById(int id) {

        Optional <Operator> optionalCliente = repo.findById(id);
        if(optionalCliente.isPresent()) {

            return optionalCliente.get();
        }

        else {

            return null;
        }
    }

    @Override
    public Collection<Operator> SearchAll() {

        return repo.findAll();
    }

    @Override
    public void deleteById(int id){
        repo.deleteById(id);
    }

    @Override
    public void update(Operator cliente){
        repo.findById(cliente.getId()).ifPresent(elCliente -> {

            repo.save(cliente);
        });
    }

    @Override    
    public void add(Operator cliente){
        repo.save(cliente);
    }

    @Override
    public Boolean login(String username, String password) {

        Boolean autenticado = false;
        Operator cliente = repo.findByUsername(username);

        if(cliente!=null) {

            if(cliente.getPassword().equals(password)) {
                
                autenticado = true;
            }
        }
        return autenticado;
    }

    @Override
    public Operator findByUsername(String username) {
        return repo.findByUsername(username);
    }


}
