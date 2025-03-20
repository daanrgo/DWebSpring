package com.example.portico.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.entidad.Comida;
import com.example.portico.repositorio.ComidaRepository;

@Service
public class ComidaServiceImpl implements ComidaService {
 
    @Autowired
    ComidaRepository repo;

    @Override
    public Comida SearchById(Integer id) {

        Optional <Comida> optionalComida = repo.findById(id);
        if(optionalComida.isPresent()) {
            Comida comida = optionalComida.get();
            comida.setAdicionalesSeleccionados(new HashMap<>());
            return comida;
        }

        else {

            return null;
        }
        
    }

    @Override
    public Collection<Comida> SearchAll() {

        return repo.findAll();
    }

    @Override
    public void deleteById(int id){

        repo.deleteById(id);
    }

    @Override
    public void update(Comida comida){

        repo.findById(comida.getId()).ifPresent(laComida -> {
            repo.save(comida);
        });
    }

    @Override    
    public void add(Comida comida){

        repo.save(comida);
    }

    
}
