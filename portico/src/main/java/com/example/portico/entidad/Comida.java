package com.example.portico.entidad;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name="product_extra", 
        joinColumns = @JoinColumn(name = "comida_id"), 
        inverseJoinColumns = @JoinColumn(name = "extra_id"))
    private List<Adicional> adicionales = new ArrayList<>();

    @OneToMany(mappedBy = "comida")
    private List<OrderEntity> orders = new ArrayList<>();



    
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
        this.adicionalesSeleccionados = new HashMap<>();
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
                + imagen + ", adicionales=" + adicionales + ", orders=" + orders + ", adicionalesSeleccionados="
                + adicionalesSeleccionados + "]";
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

    public void setAdicionales(List<Adicional> adicionales) {
        this.adicionales = adicionales;
    }

    public HashMap<Integer, Boolean> getAdicionalesSeleccionados() {
        return adicionalesSeleccionados;
    }
    public void setAdicionalesSeleccionados(HashMap<Integer, Boolean> adicionalesSeleccionados) {
        this.adicionalesSeleccionados = adicionalesSeleccionados;
    }

    
    public List<Adicional> getAdicionales() {
        return adicionales;
    }

    public void addAdicional(Adicional adicional){
        this.adicionales.add(adicional);
        this.adicionalesSeleccionados.put(adicional.getId(), false);
    } 
}
