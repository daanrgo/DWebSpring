package com.example.portico.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Adicional;
import com.example.portico.entidad.Comida;
@Repository
public class AdicionalRepository {
    private Map<Integer, Adicional> data = new HashMap<>();

    public AdicionalRepository() {

        data.put(1, new Adicional(1, "Papas", 25000));
        data.put(2, new Adicional(2, "anillos de cebolla", 30000));
        data.put(3, new Adicional(3, "Limonada", 35000));
    }

    public Collection<Adicional> findAll() {
        
        return data.values();
    }

    public Adicional findById(int id) {

        return data.get(id);
    }

    public void deleteById(int id){
        data.remove(id);
    }

    public void update(Adicional adicional){
        data.put(adicional.getId(), adicional);
    }

    public void add(Adicional adicional) {
        int tam = data.size();
        int lastId = data.get(tam).getId();
        adicional.setId(lastId + 1);
        data.put(adicional.getId(), adicional);
    }
}
