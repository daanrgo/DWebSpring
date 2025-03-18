package com.example.portico.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderEntity {
    
    @Id
    @GeneratedValue
    private Integer id;

    private Integer quantity;


    @ManyToOne
    private Comida comida;

    @ManyToOne
    private Bill bill;



    public OrderEntity () {


    }

    public OrderEntity (Integer quantity) {
        
        this.quantity = quantity;
    }



    public Integer getQuantity() {
        return quantity;
    }



    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}
