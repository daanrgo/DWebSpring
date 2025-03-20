package com.example.portico.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.portico.repositorio.AdicionalRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.example.portico.entidad.Adicional;
import com.example.portico.entidad.Comida;

@Service
public class AdicionalServicelmpl implements AdicionalService {
    
    @Autowired
    AdicionalRepository repo;

    @Override
    public Adicional SearchById(int id) {

        Optional <Adicional> optionalAdicional = repo.findById(id);
        if(optionalAdicional.isPresent()) {
            
            return optionalAdicional.get();
        }

        else {

            return null;
        }
        
    }

    @Override
    public Collection<Adicional> SearchAll() {

        return repo.findAll();
    }

    @Override
    public void deleteById(int id){
        Adicional adicional = repo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Not found"));

        for (Comida comida : adicional.getComidas()) {
            comida.getAdicionales().remove(adicional); // removes join table entry
        }

        adicional.getComidas().clear(); // just in case

        repo.save(adicional); // persist removal of associations

        repo.delete(adicional); // now delete adicional safely

        repo.deleteById(id);
    }

    @Override
    public void update(Adicional adicional){
        
        repo.findById(adicional.getId()).ifPresent(elAdicional -> {

            repo.save(adicional);
        });
    }

    @Override    
    public void add(Adicional adicional){
        
        repo.save(adicional);
    }
}
