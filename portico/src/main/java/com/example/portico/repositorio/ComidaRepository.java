package com.example.portico.repositorio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Adicional;
import com.example.portico.entidad.Comida;

@Repository
public class ComidaRepository {

       //@Autowired
       //AdicionalRepository adicionalRepository; 

    private Map<Integer, Comida> data = new HashMap<>();

    public ComidaRepository() {

        Adicional quesoExtra = new Adicional(1, "Queso Extra", 3000);
        Adicional papasExtra = new Adicional(2, "Papas Adicionales", 5000);
        Adicional maniExtra = new Adicional(3, "Mani Extra", 3000);
        Adicional anillosExtra = new Adicional(4, "Anillos Adicionales", 5000);

        // Agregar adicionales a cada comida
        /*HashMap<Integer, Adicional> adicionales1 = new HashMap<>();
        adicionales1.put(quesoExtra.getId(), quesoExtra);
        adicionales1.put(papasExtra.getId(), papasExtra);
        adicionales1.put(maniExtra.getId(), maniExtra);

        HashMap<Integer, Adicional> adicionales2 = new HashMap<>();
        adicionales1.put(quesoExtra.getId(), quesoExtra);
        adicionales1.put(papasExtra.getId(), papasExtra);
        /* */
        Comida comida = new Comida(
                1,
                "Hamburguesa \"El Portico\"", 
                25000, "\"Con esta te sientes en casa\"",
                "/images/burger4.png");
        

        comida.getAdicionales().add(quesoExtra);
        comida.getAdicionales().add(anillosExtra);
        data.put(1, comida);

        comida = new Comida(2, "Hamburguesa \"El Noble\"", 30000, "\"Una forma elegante de comer sabroso\"",
        "/images/hamburgesa.png");
        comida.getAdicionales().add(quesoExtra);
        data.put(2, comida);

        /* 
        data.put(3, new Comida(3, "Hamburguesa \"El Príncipe\"", 35000, "\"No necesitas trono para comerla\"",
                "/images/burger6.png", adicionales1));
        data.put(4, new Comida(4, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"",
                "/images/burger4.png", adicionales2));
        data.put(5, new Comida(5, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"",
                "/images/burger4.png", adicionales1));
        data.put(6, new Comida(6, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"",
                "/images/burger4.png", adicionales2));
        data.put(7, new Comida(7, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"",
                "/images/burger4.png", adicionales1));
        data.put(8, new Comida(8, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"",
                "/images/burger4.png", adicionales2));
        data.put(9, new Comida(9, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"",
                "/images/burger4.png", adicionales1));
        */
        
    }

    public Collection<Comida> findAll() {

        return data.values();
    }

    public Comida findById(int id) {

        return data.get(id);
    }

    public void deleteById(int id) {
        data.remove(id);
    }

    public void update(Comida comida) {
        data.put(comida.getId(), comida);
    }

    public void add(Comida comida) {
        int tam = data.size();
        int lastId = data.get(tam).getId();
        comida.setId(lastId + 1);
        data.put(comida.getId(), comida);
    }
}