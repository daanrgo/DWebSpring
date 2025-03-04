package com.example.portico.entidad;

public class Adicional {
    
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
    
    public Adicional(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
 
    private Integer id;
    private String name;
    private Integer price;
}

