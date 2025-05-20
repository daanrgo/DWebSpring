// Proyecto: SPRING BOOT
// Archivo: src/main/java/com/example/portico/controlador/ComidaRestController.java

package com.example.portico.controlador;

import com.example.portico.dto.ComidaDTO;
import com.example.portico.dto.ComidaInputDTO;
import com.example.portico.dto.DTOIdUsuarioComida;
import com.example.portico.dto.DTOIdUsuarioComidas;
import com.example.portico.entidad.Comida;
import com.example.portico.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comidas")
@CrossOrigin(origins = "http://localhost:4200")
public class ComidaRestController {

    @Autowired
    private ComidaService comidaService;

    @GetMapping("/{userId}/{comidaId}")
    public ResponseEntity<DTOIdUsuarioComida> getComidaById(
        @PathVariable Integer userId,
        @PathVariable Integer comidaId) {
        return ResponseEntity.ok(comidaService.getComidaDTOForUser(userId, comidaId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<DTOIdUsuarioComidas> getAllComidasForUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(comidaService.getAllComidasDTOForUser(userId));
    }

    @PostMapping("/{userId}/create")
    public ResponseEntity<ComidaDTO> createComida(
        @PathVariable Integer userId,
        @RequestBody ComidaInputDTO dto) {

        Comida comida = comidaService.addFromInputDTO(dto);
        return ResponseEntity.ok(comidaService.convertToComidaDTO(comida));
    }

    @PutMapping("/{userId}/update/{id}")
    public ResponseEntity<ComidaDTO> updateComida(
        @PathVariable Integer userId,
        @PathVariable Integer id,
        @RequestBody ComidaInputDTO dto) {

        Comida updated = comidaService.updateFromInputDTO(id, dto);
        return ResponseEntity.ok(comidaService.convertToComidaDTO(updated));
    }

    @DeleteMapping("/{userId}/delete/{id}")
    public ResponseEntity<Void> deleteComida(
        @PathVariable Integer userId,
        @PathVariable Integer id) {

        comidaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}