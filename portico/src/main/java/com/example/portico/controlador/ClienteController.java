package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portico.entidad.Cliente;
import com.example.portico.service.ClienteService;

@RequestMapping("/cliente")
@Controller
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public String mostrarClientes(Model model) {

        model.addAttribute("clientes", clienteService.SearchAll());
        return "tabla_cliente";
    }

    @GetMapping("/find/{id}")
    public String getMethodName(Model model, @PathVariable("id") int id) {
       
        model.addAttribute("cliente", clienteService.SearchById(id));
        
        return "perfil_cliente";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Cliente cliente = new Cliente(0,null,null,null,null,null,0,null);
        model.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    @PostMapping("/create")
    public String crearComida(Model model, Cliente cliente){
        clienteService.add(cliente);
        return "redirect:/cliente/all";
    }

    @PostMapping("/delete/{id}")
    public String eliminarComida(@PathVariable("id") int id){
        clienteService.deleteById(id);
        return "redirect:/cliente/all";
    }
}
