package com.example.portico.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.portico.entidad.Bill;

@Service
public interface BillService {
    
    public Bill SearchById(Integer id);

    public Collection<Bill> SearchAll();

    public void deleteById(int id);

    public void update(Bill comida);

    public void add(Bill bill, int client_id);
}
