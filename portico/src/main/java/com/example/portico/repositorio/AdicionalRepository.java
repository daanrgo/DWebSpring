package com.example.portico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Adicional;
@Repository
public interface AdicionalRepository extends JpaRepository<Adicional, Integer>{


}
