package com.example.portico.dto;

import java.util.List;

public class ComidaInputDTO {
    private String name;
    private Double price;
    private String description;
    private String imagen;
    private List<Integer> adicionalesIds;

    public ComidaInputDTO() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Integer> getAdicionalesIds() {
        return adicionalesIds;
    }
    public void setAdicionalesIds(List<Integer> adicionalesIds) {
        this.adicionalesIds = adicionalesIds;
    }
}
