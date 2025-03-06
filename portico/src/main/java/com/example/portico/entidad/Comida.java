package com.example.portico.entidad;

import java.util.ArrayList;
import java.util.HashMap;

public class Comida {
    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private String imagen; // Se guarda el url de la imagen
    private HashMap<Integer, Boolean> adicionalesSeleccionados;
    private ArrayList<Adicional> adicionales;

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
        this.adicionalesSeleccionados = new HashMap<Integer, Boolean>();
        this.adicionales = new ArrayList<>();
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public HashMap<Integer, Boolean> getAdicionalesSeleccionados() {
        return adicionalesSeleccionados;
    }
    public void setAdicionalesSeleccionados(HashMap<Integer, Boolean> adicionalesSeleccionados) {
        this.adicionalesSeleccionados = adicionalesSeleccionados;
    }
    public ArrayList<Adicional> getAdicionales() {
        return adicionales;
    }
    /*public void setAdicionales(ArrayList<Adicional> adicionales) {
        this.adicionales = adicionales;
        this.adicionalesSeleccionados = new HashMap<Integer, Boolean>();

        for(Adicional adicional : adicionales.values()){
            adicionalesSeleccionados.put(adicional.getId(), false);
        }
    }   */ 
}
