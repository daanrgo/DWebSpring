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

        data.put(1, new Comida(1, "Hamburguesa Triple Queso", 25000, "Es una hamburguesa con triple carne, sencillo", "https://imagenes.eltiempo.com/files/image_1200_600/uploads/2024/05/03/66351b3e54969.jpeg"));
        data.put(2, new Comida(1, "Hamburguesa Doble Queso", 30000, "Es una hamburguesa con Doble carne, sencillo", "https://imagenes.eltiempo.com/files/image_1200_600/uploads/2024/05/03/66351b3e54969.jpeg"));
        data.put(3, new Comida(1, "Hamburguesa Sin Queso", 35000, "Es una hamburguesa con triple carne, sencillo", "https://imagenes.eltiempo.com/files/image_1200_600/uploads/2024/05/03/66351b3e54969.jpeg"));
        data.put(4, new Comida(1, "Hamburguesa Con Queso", 30000, "Es una hamburguesa con triple carne, sencillo", "https://imagenes.eltiempo.com/files/image_1200_600/uploads/2024/05/03/66351b3e54969.jpeg"));

    }

    public Collection<Comida> findAll() {
        
        return data.values();
    }

    public Comida findById(int id) {

        return data.get(id);
    }

}