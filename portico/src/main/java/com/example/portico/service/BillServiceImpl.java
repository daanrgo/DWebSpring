// src/main/java/com/example/portico/service/BillServiceImpl.java

package com.example.portico.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.dto.ComidaDTO;
import com.example.portico.dto.DTOIdUsuarioComidas;
import com.example.portico.entidad.Bill;
import com.example.portico.entidad.Cliente;
import com.example.portico.entidad.Comida;
import com.example.portico.entidad.Courier;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.repositorio.BillRepository;
import com.example.portico.repositorio.ClienteRepository;
import com.example.portico.repositorio.ComidaRepository;
import com.example.portico.repositorio.OrderEntityRepository;
import com.example.portico.repositorio.PaymentTypeRepository;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository repo;

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComidaRepository comidaRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public Bill SearchById(Integer id) {
        Optional<Bill> optionalComida = repo.findById(id);
        return optionalComida.orElse(null);
    }

    @Override
    public Collection<Bill> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Bill bill) {
        repo.findById(bill.getId()).ifPresent(existing -> repo.save(bill));
    }

    @Override
    public void add(Bill bill, int client_id, List<OrderEntity> comidas) {
        if (comidas == null || comidas.isEmpty()) {
            throw new IllegalArgumentException("El pedido debe contener al menos un item");
        }

        Cliente cliente = clienteRepository.findById(client_id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        bill.setClient(cliente);
        repo.save(bill);

        for (OrderEntity comida : comidas) {
            Comida comida_encontrada = comidaRepository.findById(comida.getComida().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Comida no encontrada"));

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setQuantity(comida.getQuantity());
            orderEntity.setComida(comida_encontrada);
            orderEntity.setBill(bill);

            orderEntityRepository.save(orderEntity);
        }
    }

    @Override
    public Bill asignarRepartidor(Integer billId, Integer courierId) {
        Bill bill = repo.findById(billId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));

        Courier courier = new Courier();
        courier.setId(courierId);

        bill.setCourier(courier);
        return repo.save(bill);
    }

    @Override
    public Bill actualizarEstadoPedido(Integer billId, Integer nuevoEstado) {
        Bill bill = repo.findById(billId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));

        bill.setStatus(nuevoEstado);
        return repo.save(bill);
    }

    @Override
    public Bill crearFacturaDesdePedido(DTOIdUsuarioComidas dto) {
    if (dto.getComidas() == null || dto.getComidas().isEmpty()) {
        throw new IllegalArgumentException("La lista de comidas no puede ser nula o vacía.");
    }

    Bill bill = new Bill();

    // Buscar el cliente
    Cliente cliente = clienteRepository.findById(dto.getUser_id())
        .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

    // Setear cliente y address correctamente
    bill.setClient(cliente);
    bill.setAddress(cliente.getAddress()); // <- Ahora sí seteamos la dirección
    bill.setStatus(1); // Estado inicial "Recibido", opcional pero recomendable
    bill.setCreationDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

    List<OrderEntity> ordenes = dto.getComidas().stream().map(comidaDTO -> {
        if (comidaDTO.getId() == null) {
            throw new IllegalArgumentException("ID de comida no puede ser nulo.");
        }

        OrderEntity o = new OrderEntity();
        o.setQuantity(comidaDTO.getQuantity() != null ? comidaDTO.getQuantity() : 1);
        Comida comida = new Comida();
        comida.setId(comidaDTO.getId());
        o.setComida(comida);
        o.setBill(bill);
        return o;
    }).collect(Collectors.toList());

    add(bill, dto.getUser_id(), ordenes);

    return bill;
}

    @Override
    public List<Bill> findByClientId(int clientId) {
        return repo.findAll().stream()
                .filter(bill -> bill.getClient() != null && bill.getClient().getId() == clientId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Bill> findByCourierId(int courierId) {
        return repo.findAll().stream()
                .filter(bill -> bill.getCourier() != null && bill.getCourier().getId() == courierId)
                .collect(Collectors.toList());
    }



}
