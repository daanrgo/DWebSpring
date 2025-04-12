// src/main/java/com/example/portico/service/OrderServiceImpl.java

package com.example.portico.service;

import com.example.portico.entidad.OrderEntity;
import com.example.portico.repositorio.OrderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderEntityRepository orderRepo;

    @Override
    public OrderEntity findById(int id) {
        Optional<OrderEntity> result = orderRepo.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public void save(OrderEntity order) {
        orderRepo.save(order);
    }

    @Override
    public void deleteById(int id) {
        orderRepo.deleteById(id);
    }
}
