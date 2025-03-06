package com.example.portico.entidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Comida {
    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private String imagen; // Se guarda el url de la imagen
    private HashMap<String, Boolean> adicionales;

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
    @Override
    public String toString() {
        return "Comida [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", imagen="
                + imagen + "]";
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
    public Comida(Integer id, String name, Integer price, String description, String imagen) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagen = imagen;
        this.adicionales = new HashMap<String, Boolean>();
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public HashMap<String, Boolean> getAdicionales() {
        return adicionales;
    }
    public void setAdicionales(HashMap<String, Boolean> adicionales) {
        this.adicionales = adicionales;
    }
}
