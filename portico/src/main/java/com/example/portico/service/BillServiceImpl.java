package com.example.portico.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.entidad.Bill;
import com.example.portico.repositorio.BillRepository;

@Service
public class BillServiceImpl implements BillService {
 
    @Autowired
    BillRepository repo;

    @Override
    public Bill SearchById(Integer id) {

        Optional <Bill> optionalComida = repo.findById(id);
        if(optionalComida.isPresent()) {
            
            return optionalComida.get();
        }

        else {

            return null;
        }
        
    }

    @Override
    public Collection<Bill> SearchAll() {

        return repo.findAll();
    }

    @Override
    public void deleteById(int id){

        repo.deleteById(id);
    }

    @Override
    public void update(Bill comida){

        repo.findById(comida.getId()).ifPresent(laComida -> {

            repo.save(comida);
        });
    }

    @Override    
    public void add(Bill bill, int client_id){

        repo.save(bill);
    }

    
}
