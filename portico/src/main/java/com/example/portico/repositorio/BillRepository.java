package com.example.portico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

      
}