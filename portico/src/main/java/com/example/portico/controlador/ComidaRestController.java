package com.example.portico.controlador;

import com.example.portico.dto.*;
import com.example.portico.entidad.Comida;
import com.example.portico.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/comidas/{user_id}")
@CrossOrigin(origins = "http://localhost:4200")
public class ComidaRestController {

    @Autowired
    private ComidaService comidaService;

    @GetMapping("")
    public ResponseEntity<DTOIdUsuarioComidas> getAllComidas(@PathVariable("user_id") int user_id) {
        return ResponseEntity.ok(comidaService.getAllComidasDTOForUser(user_id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOIdUsuarioComida> getComidaById(
            @PathVariable("id") int id, 
            @PathVariable("user_id") int user_id) {
        DTOIdUsuarioComida dto = comidaService.getComidaDTOForUser(user_id, id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/adicionales")
    public ResponseEntity<AdicionalesDTO> getAdicionales(
            @PathVariable("id") int comidaId,
            @RequestParam Map<Integer, Boolean> selecciones) {
        AdicionalesDTO dto = comidaService.getAdicionalesDTO(comidaId, selecciones);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Comida> createComida(
            @RequestBody Comida comida, 
            @PathVariable("user_id") int user_id) {
        if (comida.getAdicionalesSeleccionados() == null) {
            comida.setAdicionalesSeleccionados(new HashMap<>());
        }
        Comida nuevaComida = comidaService.add(comida);
        return ResponseEntity.ok(nuevaComida);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Comida> updateComida(
            @PathVariable("id") int id, 
            @RequestBody Comida comida) {
        comida.setId(id);
        if (comida.getAdicionalesSeleccionados() == null) {
            comida.setAdicionalesSeleccionados(new HashMap<>());
        }
        Comida comidaActualizada = comidaService.update(comida);
        return ResponseEntity.ok(comidaActualizada);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComida(@PathVariable("id") int id) {
        comidaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/adicionales")
    public ResponseEntity<AdicionalesDTO> addAdicionales(
            @PathVariable("id") int comidaId,
            @RequestBody Map<Integer, Boolean> adicionalesSeleccionados,
            @PathVariable("user_id") int user_id) {
        Comida comida = comidaService.searchById(comidaId);
        if (comida == null) {
            return ResponseEntity.notFound().build();
        }
        
        comida.setAdicionalesSeleccionados(new HashMap<>(adicionalesSeleccionados));
        comidaService.update(comida);
        
        AdicionalesDTO dto = comidaService.getAdicionalesDTO(comidaId, adicionalesSeleccionados);
        return ResponseEntity.ok(dto);
    }
}