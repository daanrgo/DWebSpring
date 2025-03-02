package com.example.portico.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Comida;


@Repository
public class ComidaRepository {

    private Map<Integer, Comida> data = new HashMap<>();

    public ComidaRepository() {

        data.put(1, new Comida(1, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"", "/portico_spring/portico/src/main/resources/static/images/burger4.png"));
        data.put(2, new Comida(2, "Hamburguesa \"El Noble\"", 30000, "\"Una forma elegante de comer sabroso\"", "/portico_spring/portico/src/main/resources/static/images/hamburgesa.png"));
        data.put(3, new Comida(3, "Hamburguesa \"El Príncipe\"", 35000, "\"No necesitas trono para comerla\"", "/portico_spring/portico/src/main/resources/static/images/burger6.png"));
        data.put(4, new Comida(4, "Hamburguesa Con Queso", 30000, "Es una hamburguesa con triple carne, sencillo", "https://imagenes.eltiempo.com/files/image_1200_600/uploads/2024/05/03/66351b3e54969.jpeg"));
        data.put(5, new Comida(5, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"", "/portico_spring/portico/src/main/resources/static/images/burger4.png"));
        data.put(6, new Comida(6, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"", "/portico_spring/portico/src/main/resources/static/images/burger4.png"));
        data.put(7, new Comida(7, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"", "/portico_spring/portico/src/main/resources/static/images/burger4.png"));
        data.put(8, new Comida(8, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"", "/portico_spring/portico/src/main/resources/static/images/burger4.png"));
        data.put(9, new Comida(9, "Hamburguesa \"El Portico\"", 25000, "\"Con esta te sientes en casa\"", "/portico_spring/portico/src/main/resources/static/images/burger4.png"));


    }

    public Collection<Comida> findAll() {
        
        return data.values();
    }

    public Comida findById(int id) {

        return data.get(id);
    }

}