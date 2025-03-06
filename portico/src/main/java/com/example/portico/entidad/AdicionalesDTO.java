package com.example.portico.entidad;

import java.util.HashMap;
import java.util.Map;

public class AdicionalesDTO {
    private HashMap<Integer, Boolean> adicionalesSeleccionados = new HashMap<>();
    private HashMap<Integer, Adicional> adicionales = new HashMap<>();
    private int comidaId;

    

    
    @Override
    public String toString() {
        return "AdicionalesDTO [adicionalesSeleccionados=" + adicionalesSeleccionados.toString() + ", adicionales=" + adicionales.toString()
                + ", comidaId=" + comidaId + "]";
    }
    public HashMap<Integer, Boolean> getAdicionalesSeleccionados() {
        return adicionalesSeleccionados;
    }
    public void setAdicionalesSeleccionados(HashMap<Integer, Boolean> adicionalesMap) {
        this.adicionalesSeleccionados = adicionalesMap;
    }
    public int getComidaId() {
        return comidaId;
    }
    public HashMap<Integer, Adicional> getAdicionales() {
        return adicionales;
    }
    public void setAdicionales(HashMap<Integer, Adicional> adicionalesObjectMap) {
        this.adicionales = adicionalesObjectMap;
    }
    public void setComidaId(int comidaId) {
        this.comidaId = comidaId;
    }
    public AdicionalesDTO(HashMap<Integer, Boolean> adicionalesSeleccionados, HashMap<Integer, Adicional> adicionales,
            int comidaId) {
        this.adicionalesSeleccionados = adicionalesSeleccionados;
        this.adicionales = adicionales;
        this.comidaId = comidaId;
    }
}
