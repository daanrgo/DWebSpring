package com.example.portico.entidad;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OrderEntity {
    
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Integer quantity;


    @ManyToOne
    private Comida comida;

    @ManyToOne
    private Bill bill;

    @OneToMany(mappedBy = "order")
    private List<OrderExtra> orderExtras;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }



}
