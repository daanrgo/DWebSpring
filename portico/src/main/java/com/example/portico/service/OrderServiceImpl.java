// src/main/java/com/example/portico/service/OrderServiceImpl.java

package com.example.portico.service;

import com.example.portico.dto.OrderStatusDTO;
import com.example.portico.entidad.Bill;
import com.example.portico.entidad.Comida;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.repositorio.OrderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<OrderStatusDTO> findAllConEstado() {
        return orderRepo.findAll().stream()
            .map(order -> new OrderStatusDTO(
                order.getId(),
                order.getBill().getStatus()
            ))
            .collect(Collectors.toList());
    }
    
    @Override
    public void updateStatus(int orderId, int estado) {
    OrderEntity order = orderRepo.findById(orderId)
        .orElseThrow(() -> new IllegalArgumentException("Orden no encontrada con ID: " + orderId));

    if (order.getBill() == null) {
        throw new IllegalStateException("La orden no tiene factura asociada.");
    }

    order.getBill().setStatus(estado);
    orderRepo.save(order);
    }

    @Override
public List<OrderEntity> obtenerTodosLosPedidos() {
    return orderRepo.findAll();
}

    @Override
    public OrderEntity guardarPedido(OrderEntity pedido) {
        return orderRepo.save(pedido);
    }

    @Override
    public List<OrderEntity> buscarPorFactura(Bill factura) {
        return orderRepo.findByBill(factura);
    }

    @Override
    public List<OrderEntity> buscarPorComida(Comida comida) {
        return orderRepo.findByComida(comida);
    }

}
