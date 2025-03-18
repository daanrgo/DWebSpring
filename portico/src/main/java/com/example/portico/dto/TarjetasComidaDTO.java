package com.example.portico.dto;

import java.util.Collection;

import com.example.portico.entidad.Comida;


public class TarjetasComidaDTO {
    public Collection<Comida> getComidas() {
        return comidas;
    }

    public int getUser_id() {
        return user_id;
    }

    private Collection<Comida> comidas;
    private int user_id;
    
    public TarjetasComidaDTO(int user_id, Collection<Comida> comidas) {
        this.comidas = comidas;
        this.user_id = user_id;
    }
    
}
