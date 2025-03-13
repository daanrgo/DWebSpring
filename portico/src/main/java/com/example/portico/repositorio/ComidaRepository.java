package com.example.portico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Comida;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Integer> {

      
}