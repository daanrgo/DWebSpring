package com.example.portico.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.portico.entidad.Bill;
import com.example.portico.entidad.OrderEntity;

@Service
public interface BillService {
    
    public Bill SearchById(Integer id);

    public Collection<Bill> SearchAll();

    public void deleteById(int id);

    public void update(Bill comida);

    public void add(Bill bill, int client_id, List<OrderEntity> comida);
}
