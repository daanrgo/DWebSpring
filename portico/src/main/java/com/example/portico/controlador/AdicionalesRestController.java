package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.portico.entidad.Adicional;
import com.example.portico.service.AdicionalService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/adicionales")
@CrossOrigin(origins = "http://localhost:4200") // Asegura que Angular pueda consumir este servicio


public class AdicionalesRestController {

    @Autowired
    private AdicionalService adicionalService;

    @GetMapping("")
    public List<Adicional> getAllAdicionales() {
        return new ArrayList<> (adicionalService.SearchAll());
    }

    @GetMapping("/{id}")
    public Adicional getAdicionalById(@PathVariable int id) {
        return adicionalService.SearchById(id);
    }

    @PostMapping("/create")
    public Adicional createAdicional(@RequestBody Adicional adicional) {
        adicionalService.add(adicional);
        return adicional; // Devuelve el Adicional recién creado
    }

    @PutMapping("/update/{id}")
    public Adicional updateAdicional(@PathVariable int id, @RequestBody Adicional adicional) {
        adicional.setId(id); // Asignamos el id para que se actualice
        adicionalService.update(adicional);
        return adicional; // Devuelve el Adicional actualizado
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdicional(@PathVariable int id) {
        adicionalService.deleteById(id);
    }
}
