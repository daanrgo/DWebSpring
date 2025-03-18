package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portico.entidad.Cliente;
import com.example.portico.service.ClienteService;

@RequestMapping("/clientes")
@Controller
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping("")
    public String mostrarClientes(Model model) {

        model.addAttribute("clientes", clienteService.SearchAll());
        return "tabla_cliente";
    }

    @GetMapping("/{id}")
    public String getMethodName(Model model, @PathVariable("id") int id) {
       
        
        Cliente cliente = clienteService.SearchById(id);
        if(cliente != null){
            model.addAttribute("cliente", clienteService.SearchById(id));
        }else{
            throw new NotFoundException(id);
        }

        model.addAttribute("cliente", clienteService.SearchById(id));
        
        return "perfil_cliente";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        Cliente cliente = new Cliente(0,null,null,null,null,null,0,null);
        model.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    @PostMapping("/create")
    public String crearCliente(Model model, Cliente cliente){
        clienteService.add(cliente);
        return "redirect:/clientes";
    }


    @GetMapping("/delete/{id}")
    public String eliminarCliente(@PathVariable("id") int identification){
        clienteService.deleteById(identification);
        return "redirect:/clientes";
    }


    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") int identification, Model model){
        model.addAttribute("cliente", clienteService.SearchById(identification));
        return "modificar_cliente";
    }

    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable("id") int identification, @ModelAttribute("cliente") Cliente cliente){
        
        clienteService.update(cliente);
        return "redirect:/clientes"; 
    }

}
