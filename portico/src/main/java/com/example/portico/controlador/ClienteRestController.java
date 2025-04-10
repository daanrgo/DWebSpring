// Proyecto: SPRING BOOT
// Carpeta: src/main/java/com/example/portico/controlador/ClienteRestController.java

package com.example.portico.controlador;

import com.example.portico.entidad.Cliente;
import com.example.portico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public List<Cliente> obtenerTodos() {
       return new ArrayList<>(clienteService.SearchAll());

    }

    @GetMapping("/{id}")
    public Cliente obtenerPorId(@PathVariable int id) {
        return clienteService.SearchById(id);
    }

    @PostMapping("")
    public Cliente crear(@RequestBody Cliente cliente) {
        clienteService.add(cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        clienteService.update(cliente);
        return cliente;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        clienteService.deleteById(id);
    }
}
