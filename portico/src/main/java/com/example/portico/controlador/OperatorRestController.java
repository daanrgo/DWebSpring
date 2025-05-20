// src/main/java/com/example/portico/controlador/OperatorRestController.java

package com.example.portico.controlador;

import com.example.portico.entidad.Operator;
import com.example.portico.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/operators")
@CrossOrigin(origins = "http://localhost:4200")
public class OperatorRestController {

    @Autowired
    private OperatorService operatorService;

    @GetMapping
    public Collection<Operator> getAllOperators() {
        return operatorService.SearchAll();
    }

    @GetMapping("/{id}")
    public Operator getOperatorById(@PathVariable int id) {
        return operatorService.SearchById(id);
    }

    @PostMapping
    public Operator createOperator(@RequestBody Operator operator) {
        operator.setId(null); // Forzar inserción nueva, evita colisiones
        operatorService.add(operator);
        return operator;
    }

    @PutMapping("/{id}")
    public void updateOperator(@PathVariable int id, @RequestBody Operator operator) {
        operator.setId(id);
        operatorService.update(operator);
    }

    @DeleteMapping("/{id}")
    public void deleteOperator(@PathVariable int id) {
        operatorService.deleteById(id);
    }
}
