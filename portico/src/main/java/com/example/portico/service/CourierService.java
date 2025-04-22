package com.example.portico.service;

import java.util.Collection;
import org.springframework.stereotype.Service;
import com.example.portico.entidad.Courier;

@Service
public interface CourierService {

    Courier searchById(int id);

    Collection<Courier> searchAll();

    void deleteById(int id);

    void update(Courier courier);

    void add(Courier courier);

    Courier login(String username, String password);
    
    Courier findByUsername(String username);

}
