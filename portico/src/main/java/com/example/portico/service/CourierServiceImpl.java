package com.example.portico.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.entidad.Courier;
import com.example.portico.repositorio.CourierRepository;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierRepository repo;

    @Override
    public Courier searchById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Collection<Courier> searchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Courier courier) {
        repo.findById(courier.getId()).ifPresent(c -> repo.save(courier));
    }

    @Override
    public void add(Courier courier) {
        repo.save(courier);
    }

    @Override
    public Courier login(String username, String password) {
        Courier courier = repo.findByUsername(username);
        if (courier != null && courier.getPassword().equals(password)) {
            return courier;
        }
        return null;
    }

    @Override
    public Courier findByUsername(String username) {
    return repo.findByUsername(username);
}

}
