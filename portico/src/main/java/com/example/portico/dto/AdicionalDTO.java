package com.example.portico.dto;

public class AdicionalDTO {
    private Integer id;
    private String name;  // Cambiado de 'nombre' a 'name'
    private Double price; // Cambiado de 'precio' a 'price'
    
    public AdicionalDTO() {}
    
    public AdicionalDTO(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    // Getters y setters...
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}