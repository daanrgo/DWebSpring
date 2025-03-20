package com.example.portico.dto;

import com.example.portico.entidad.Comida;

public class DTOIdUsuarioComida {
    private int user_id;
    private Comida Comida;

    
    public DTOIdUsuarioComida(int user_id, com.example.portico.entidad.Comida comida) {
        this.user_id = user_id;
        Comida = comida;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setComida(Comida comida) {
        Comida = comida;
    }
    public Comida getComida() {
        return Comida;
    }
}
