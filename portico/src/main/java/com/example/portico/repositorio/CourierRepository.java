package com.example.portico.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Courier;

@Repository
public interface CourierRepository extends JpaRepository <Courier, Integer> {
    
    Courier findByUsername(String username);
}
