package com.example.portico.dto;

import java.util.HashMap;
import java.util.Map;


public class AdicionalesDTO {
    private Map<Integer, Boolean> adicionalesSeleccionados; // ID -> Selección
    private Map<Integer, AdicionalDTO> adicionalesDisponibles; // ID -> AdicionalDTO
    private Integer comidaId;
    
    // Constructor completo
    public AdicionalesDTO(Integer comidaId, 
                         Map<Integer, Boolean> adicionalesSeleccionados,
                         Map<Integer, AdicionalDTO> adicionalesDisponibles) {
        this.comidaId = comidaId;
        this.adicionalesSeleccionados = adicionalesSeleccionados;
        this.adicionalesDisponibles = adicionalesDisponibles;
    }
    
    // Constructor vacío para frameworks
    public AdicionalesDTO() {}
    
    // Getters y Setters
    public Map<Integer, Boolean> getAdicionalesSeleccionados() {
        return adicionalesSeleccionados;
    }
    
    public void setAdicionalesSeleccionados(Map<Integer, Boolean> adicionalesSeleccionados) {
        this.adicionalesSeleccionados = adicionalesSeleccionados;
    }
    
    public Integer getComidaId() {
        return comidaId;
    }
    
    public void setComidaId(Integer comidaId) {
        this.comidaId = comidaId;
    }
    
    public Map<Integer, AdicionalDTO> getAdicionalesDisponibles() {
        return adicionalesDisponibles;
    }
    
    public void setAdicionalesDisponibles(Map<Integer, AdicionalDTO> adicionalesDisponibles) {
        this.adicionalesDisponibles = adicionalesDisponibles;
    }
    
    @Override
    public String toString() {
        return "AdicionalesDTO [comidaId=" + comidaId 
             + ", seleccionados=" + adicionalesSeleccionados 
             + ", disponibles=" + adicionalesDisponibles + "]";
    }
}