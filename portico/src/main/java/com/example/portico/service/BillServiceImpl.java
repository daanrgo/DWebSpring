package com.example.portico.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    BillRepository repo;

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

        Optional <Bill> optionalComida = repo.findById(id);
        if(optionalComida.isPresent()) {
            
            return optionalComida.get();
        }

        else {

            return null;
        }
        
    }

    @Override
    public Collection<Bill> SearchAll() {

        return repo.findAll();
    }

    @Override
    public void deleteById(int id){

        repo.deleteById(id);
    }

    @Override
    public void update(Bill comida){

        repo.findById(comida.getId()).ifPresent(laComida -> {

            repo.save(comida);
        });
    }

    @Override    
    public void add(Bill bill, int client_id, List<OrderEntity> comidas){


        if(comidas == null || comidas.isEmpty()) {

            throw new IllegalArgumentException("El pedido debe contener al menos un item");
        }

        Cliente cliente = clienteRepository.findById(client_id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));


        repo.save(bill);

        for (OrderEntity comida : comidas) {
            Comida comida_encontrada = comidaRepository.findById(comida.getComida().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Comida no encontrada: "));
            
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setQuantity(comida.getQuantity());
            orderEntity.setComida(comida_encontrada);
            orderEntity.setBill(bill);
            
            orderEntityRepository.save(orderEntity);
        }
    }


     public Bill asignarRepartidor(Integer billId, Integer courierId) {
        Bill bill = repo.findById(billId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
        
        Courier courier = new Courier();
        courier.setId(courierId);
        
        bill.setCourier(courier);
        return repo.save(bill);
    }

    public Bill actualizarEstadoPedido(Integer billId, Integer nuevoEstado) {
        Bill bill = repo.findById(billId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
        
        bill.setStatus(nuevoEstado);
        return repo.save(bill);
    }

    
}
