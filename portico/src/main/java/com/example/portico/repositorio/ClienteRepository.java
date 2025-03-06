package com.example.portico.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Cliente;

@Repository
public class ClienteRepository {
    private final Map<Integer, Cliente> data = new HashMap<>();

    public ClienteRepository() {

        data.put(1, new Cliente(1,"Pepe123", "1234", "Pepe", "Gonazalez", "pepegonzalez@gmail.com", 31531977, "calle 34 av 25"));
        data.put(2, new Cliente(2,"Pepe1234", "12345", "Pepe", "Gonazalez2", "pepegonzalez2@gmail.com", 31531977, "calle 34 av 25"));
        data.put(3, new Cliente(3,"Pepe1235", "12345", "Pepe", "Gonazalez3", "pepegonzalez3@gmail.com", 31531977, "calle 34 av 25"));
        data.put(4, new Cliente(4,"Pepe1236", "12345", "Pepe", "Gonazalez4", "pepegonzalez4@gmail.com", 31531977, "calle 34 av 25"));

    }

    public Cliente findById(int id) {

        return data.get(id);
    }


    public Collection<Cliente> findAll() {
        
        return data.values();
    }


    public void deleteById(int id) {

        data.remove(id);
    }

    public void update(Cliente cliente) {

        data.put(cliente.getId(), cliente);
    }

    public void add(Cliente cliente) {

        int tam = data.size();
        int lastId = data.get(tam).getId();
        cliente.setId(lastId+1);
        data.put(cliente.getId(), cliente);

        
    }

    public Cliente findByUsername(String username) {

        for(Cliente cliente: data.values()) {

            if(cliente.getEmail().equals(username)) {

                return cliente;
            }
        }

        return null;
    }
}
