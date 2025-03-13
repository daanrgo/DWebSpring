package com.example.portico.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Operator;

@Repository
public interface OperatorRepository extends JpaRepository <Operator, Integer> {
    
    Operator findByUsername(String username);
}
