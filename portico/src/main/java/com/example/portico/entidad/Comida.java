package com.example.portico.entidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Comida {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private Integer price;
    private String description;
    private String imagen; // Se guarda el url de la imagen

    @OneToMany(mappedBy = "comida", cascade = CascadeType.ALL)
    private List<Adicional> adicionales;

    @OneToMany(mappedBy = "comida")
    private List<OrderEntity> orders;



    
    @Transient
    private HashMap<Integer, Boolean> adicionalesSeleccionados;

    public Comida(Integer id, String name, Integer price, String description, String imagen) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagen = imagen;
        this.adicionalesSeleccionados = new HashMap<Integer, Boolean>();

    }

    public Comida( String name, Integer price, String description, String imagen) {
        
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagen = imagen;
        this.adicionalesSeleccionados = new HashMap<Integer, Boolean>();

    }

    public Comida() {
        
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
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public HashMap<Integer, Boolean> getAdicionalesSeleccionados() {
        return adicionalesSeleccionados;
    }
    public void setAdicionalesSeleccionados(HashMap<Integer, Boolean> adicionalesSeleccionados) {
        this.adicionalesSeleccionados = adicionalesSeleccionados;
    }

    /* 
    public ArrayList<Adicional> getAdicionales() {
        return adicionales;
    }
    public void addAdicional(Adicional adicional){
        this.adicionales.add(adicional);
        this.adicionalesSeleccionados.put(adicional.getId(), false);
    } */
}
