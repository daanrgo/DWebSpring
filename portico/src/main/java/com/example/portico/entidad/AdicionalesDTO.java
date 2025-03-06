package com.example.portico.entidad;

import java.util.HashMap;
import java.util.Map;

public class AdicionalesDTO {
    private HashMap<String, Boolean> adicionalesMap = new HashMap<>();
    private int comidaId;

    
    public HashMap<String, Boolean> getAdicionalesMap() {
        return adicionalesMap;
    }
    public void setAdicionalesMap(HashMap<String, Boolean> adicionalesMap) {
        this.adicionalesMap = adicionalesMap;
    }
    public int getComidaId() {
        return comidaId;
    }
    public void setComidaId(int comidaId) {
        this.comidaId = comidaId;
    }
}
