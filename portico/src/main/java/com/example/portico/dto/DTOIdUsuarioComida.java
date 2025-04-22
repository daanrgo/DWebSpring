package com.example.portico.dto;

public class DTOIdUsuarioComida {
    private Integer user_id;  // Mantenemos snake_case para consistencia con DB/plantillas
    private ComidaDTO comida;
    
    public DTOIdUsuarioComida() {}
    
    public DTOIdUsuarioComida(Integer user_id, ComidaDTO comida) {
        this.user_id = user_id;
        this.comida = comida;
    }
    
    // Getter CORREGIDO para coincidir con el nombre del campo
    public Integer getUser_id() {
        return user_id;
    }
    
    // Setter CORREGIDO
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    
    public ComidaDTO getComida() {
        return comida;
    }
    
    public void setComida(ComidaDTO comida) {
        this.comida = comida;
    }
}