package com.example.portico.entidad;

public class Comida {
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
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private String imagen; // Se guarda el url de la imagen
}
