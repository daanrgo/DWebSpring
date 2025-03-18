package com.example.portico.dto;

import java.util.Collection;

import com.example.portico.entidad.Adicional;
import com.example.portico.entidad.Cliente;
import com.example.portico.entidad.Comida;

public class CarritoDTO {
    private Collection<Comida> comidas;
    private Cliente cliente;
    private Integer costoTotal;

    private void calculateCost(){
        this.costoTotal = 0;
        for(Comida comida : comidas){
            this.costoTotal += comida.getPrice();
            for(Adicional adicional : comida.getAdicionales()){
                if(
                    comida.getAdicionalesSeleccionados()
                        .get(adicional.getId())
                ){
                    this.costoTotal += adicional.getPrice();
                }
            }
            
        }
    }

    public CarritoDTO(Collection<Comida> comidas, Cliente cliente) {
        this.comidas = comidas;
        this.cliente = cliente;
        calculateCost();
    }
}


