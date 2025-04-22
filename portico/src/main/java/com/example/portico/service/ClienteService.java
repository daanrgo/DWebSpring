package com.example.portico.service;

import java.util.Collection;
import com.example.portico.entidad.Cliente;

public interface ClienteService {

    Cliente SearchById(int id);

    Collection<Cliente> SearchAll();

    void deleteById(int id);

    void update(Cliente cliente);

    void add(Cliente cliente);

    Cliente findByUsername(String username);

    Cliente autenticar(String username, String password);
}
