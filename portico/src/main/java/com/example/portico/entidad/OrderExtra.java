package com.example.portico.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderExtra {
    
    @Id
    @GeneratedValue
    private Integer id;

    
    @ManyToOne
    private OrderEntity order;

    @ManyToOne
    private Adicional extra;

    private Integer quantity;

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public Adicional getExtra() {
        return extra;
    }

    public void setExtra(Adicional extra) {
        this.extra = extra;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
}
