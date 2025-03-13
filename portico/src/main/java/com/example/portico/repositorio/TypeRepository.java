package com.example.portico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

      
}