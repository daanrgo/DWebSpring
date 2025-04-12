// src/main/java/com/example/portico/service/OrderService.java

package com.example.portico.service;

import com.example.portico.entidad.OrderEntity;
import java.util.List;

public interface OrderService {
    OrderEntity findById(int id);
    List<OrderEntity> findAll();
    void save(OrderEntity order);
    void deleteById(int id);
}
