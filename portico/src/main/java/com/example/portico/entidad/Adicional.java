package com.example.portico.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Adicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @ManyToMany(mappedBy = "adicionales")
    @JsonIgnore
    private List<Comida> comidas = new ArrayList<>();

    @OneToMany(mappedBy = "extra")
    @JsonIgnore
    private List<OrderExtra> orderExtras;

    public Adicional() {}

    public Adicional(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Adicional(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    public List<OrderExtra> getOrderExtras() {
        return orderExtras;
    }

    public void setOrderExtras(List<OrderExtra> orderExtras) {
        this.orderExtras = orderExtras;
    }

    @Override
    public String toString() {
        return "Adicional [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
