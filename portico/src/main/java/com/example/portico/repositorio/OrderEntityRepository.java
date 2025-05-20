package com.example.portico.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portico.entidad.Bill;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.entidad.Comida;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findByBill(Bill bill);
    List<OrderEntity> findByComida(Comida comida); 
    List<OrderEntity> findByBillAndComida(Bill bill, Comida comida);
    List<OrderEntity> findByQuantityGreaterThan(int cantidad);
    List<OrderEntity> findByQuantityBetween(int min, int max);
}

