// src/main/java/com/example/portico/service/BillService.java

package com.example.portico.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.portico.dto.DTOIdUsuarioComidas;
import com.example.portico.entidad.Bill;
import com.example.portico.entidad.OrderEntity;

@Service
public interface BillService {

    Bill SearchById(Integer id);

    Collection<Bill> SearchAll();

    void deleteById(int id);

    void update(Bill bill);

    void add(Bill bill, int client_id, List<OrderEntity> orders);

    Bill asignarRepartidor(Integer billId, Integer courierId);

    Bill actualizarEstadoPedido(Integer billId, Integer nuevoEstado);

    Bill crearFacturaDesdePedido(DTOIdUsuarioComidas dto);

    List<Bill> findByClientId(int clientId);

    List<Bill> findByCourierId(int courierId);  // <- NUEVO MÉTODO AÑADIDO
}
