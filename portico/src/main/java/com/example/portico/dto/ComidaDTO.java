package com.example.portico.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComidaDTO {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String imagen;
    private List<AdicionalDTO> adicionales;
    private Map<Integer, Boolean> adicionalesSeleccionados;
    private Integer quantity;

    public ComidaDTO() {}

    public ComidaDTO(Integer id, String name, Double price, String description, String imagen,
                     List<AdicionalDTO> adicionales, Map<Integer, Boolean> adicionalesSeleccionados,
                     Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagen = imagen;
        this.adicionales = adicionales;
        this.adicionalesSeleccionados = adicionalesSeleccionados;
        this.quantity = quantity;
    }

    // Constructor auxiliar con valores por defecto para los campos opcionales
    public ComidaDTO(Integer id, String name, Double price, String description, String imagen, List<AdicionalDTO> adicionales) {
        this(id, name, price, description, imagen, adicionales, new HashMap<>(), 1);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public List<AdicionalDTO> getAdicionales() { return adicionales; }
    public void setAdicionales(List<AdicionalDTO> adicionales) { this.adicionales = adicionales; }
    public Map<Integer, Boolean> getAdicionalesSeleccionados() { return adicionalesSeleccionados; }
    public void setAdicionalesSeleccionados(Map<Integer, Boolean> adicionalesSeleccionados) {
        this.adicionalesSeleccionados = adicionalesSeleccionados;
    }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
