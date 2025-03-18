package com.example.portico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portico.entidad.OrderEntity;

public interface  OrderEntityRepository extends JpaRepository<OrderEntity, Integer>{
    
}
