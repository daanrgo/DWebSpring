package com.example.portico.dto;

import java.util.Collection;
import java.util.List;

public class DTOIdUsuarioComidas {
    private Integer user_id;  // Mantenemos snake_case
    private List<ComidaDTO> comidas;
    
    public DTOIdUsuarioComidas() {}
    
    public DTOIdUsuarioComidas(Integer user_id, Collection<ComidaDTO> comidas) {
        this.user_id = user_id;
        this.comidas = (List<ComidaDTO>) comidas;
    }
    
    // Getter CORREGIDO
    public Integer getUser_id() {
        return user_id;
    }
    
    // Setter CORREGIDO
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    
    public List<ComidaDTO> getComidas() {
        return comidas;
    }
    
    public void setComidas(List<ComidaDTO> comidas) {
        this.comidas = comidas;
    }
}