package com.example.portico.dto;

import com.example.portico.entidad.Comida;

public class ComidaIndividualDTO {
    private int user_id;
    private Comida Comida;

    
    public ComidaIndividualDTO(int user_id, com.example.portico.entidad.Comida comida) {
        this.user_id = user_id;
        Comida = comida;
    }
    public int getUser_id() {
        return user_id;
    }
    public Comida getComida() {
        return Comida;
    }
}
