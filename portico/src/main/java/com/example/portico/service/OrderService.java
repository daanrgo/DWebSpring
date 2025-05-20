// src/main/java/com/example/portico/service/OrderService.java

package com.example.portico.service;

import com.example.portico.dto.OrderStatusDTO;
import com.example.portico.entidad.Bill;
import com.example.portico.entidad.Comida;
import com.example.portico.entidad.OrderEntity;
import java.util.List;

public interface OrderService {
    
    OrderEntity findById(int id);
    List<OrderEntity> findAll();
    void save(OrderEntity order);
    void deleteById(int id);
    void updateStatus(int orderId, int estado);
    List<OrderStatusDTO> findAllConEstado();

    List<OrderEntity> obtenerTodosLosPedidos();
    OrderEntity guardarPedido(OrderEntity pedido);
    List<OrderEntity> buscarPorFactura(Bill factura);
    List<OrderEntity> buscarPorComida(Comida comida);


}
