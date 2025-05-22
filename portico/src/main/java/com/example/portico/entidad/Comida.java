package com.example.portico.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comida {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer price;

    private String description;
    private String imagen;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "product_extra",
        joinColumns = @JoinColumn(name = "comida_id"),
        inverseJoinColumns = @JoinColumn(name = "extra_id")
    )
    @Builder.Default
    private List<Adicional> adicionales = new ArrayList<>();

    @OneToMany(mappedBy = "comida")
    @Builder.Default
    private List<OrderEntity> orders = new ArrayList<>();

    @Transient
    @Builder.Default
    private HashMap<Integer, Boolean> adicionalesSeleccionados = new HashMap<>();

    public void addAdicional(Adicional adicional) {
        this.adicionales.add(adicional);
        this.adicionalesSeleccionados.put(adicional.getId(), false);
    }

    @Override
    public String toString() {
        return "Comida [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", imagen=" + imagen + ", adicionales=" + adicionales + ", orders=" + orders + ", adicionalesSeleccionados=" + adicionalesSeleccionados + "]";
    }
}
