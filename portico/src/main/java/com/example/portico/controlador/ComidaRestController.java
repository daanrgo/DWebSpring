// src/main/java/com/example/portico/controlador/ComidaRestController.java

package com.example.portico.controlador;

import com.example.portico.entidad.Comida;
import com.example.portico.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.portico.dto.DTOIdUsuarioComidas;
import com.example.portico.dto.DTOIdUsuarioComida;
import com.example.portico.service.AdicionalService;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/comidas/{user_id}")
@CrossOrigin(origins = "http://localhost:4200") // Permitir peticiones desde Angular
public class ComidaRestController {

    @Autowired
    ComidaService comidaService;

    @Autowired
    AdicionalService adicionalService;

    // Obtener todas las comidas para un usuario
    @GetMapping("")
    public DTOIdUsuarioComidas getAllComidas(@PathVariable("user_id") int user_id) {
        return new DTOIdUsuarioComidas(user_id, comidaService.SearchAll());
    }

    // Ver comida individual
    @GetMapping("/{id}")
    public DTOIdUsuarioComida getComidaById(@PathVariable("id") int id, @PathVariable("user_id") int user_id) {
        return new DTOIdUsuarioComida(user_id, comidaService.SearchById(id));
    }

    // Crear nueva comida
    @PostMapping("/create")
    public Comida createComida(@RequestBody Comida comida, @PathVariable("user_id") int user_id) {
        comidaService.add(comida);
        return comida;  // Se devuelve la comida creada
    }

    // Actualizar comida existente
    @PutMapping("/update/{id}")
    public Comida updateComida(@PathVariable("id") int id, @RequestBody Comida comida) {
        comida.setId(id);  // Asegurarnos de que el id sea el correcto
        comidaService.update(comida);
        return comida;  // Se devuelve la comida actualizada
    }

    // Eliminar comida
    @DeleteMapping("/delete/{id}")
    public void deleteComida(@PathVariable("id") int id) {
        comidaService.deleteById(id);
    }

    // Agregar adicionales a una comida
    @PostMapping("/add_adicionales")
    public Comida addAdicionales(@RequestBody Comida comida, @PathVariable("user_id") int user_id) {
        Comida comidaExistente = comidaService.SearchById(comida.getId());
        comidaExistente.setAdicionalesSeleccionados(comida.getAdicionalesSeleccionados());
        comidaService.update(comidaExistente);
        return comidaExistente;
    }
}

