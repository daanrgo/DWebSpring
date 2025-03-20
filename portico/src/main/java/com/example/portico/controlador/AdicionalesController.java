package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portico.entidad.Adicional;
import com.example.portico.service.AdicionalService;


@RequestMapping("/adicionales")
@Controller
public class AdicionalesController {

    @Autowired
    AdicionalService adicionalService;

    @GetMapping("")
    public String mostrarInfoAdicionales(Model model) {
        model.addAttribute("adicionales", adicionalService.SearchAll());
        return "tabla_adicionales";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        Adicional adicional = new Adicional(0, "", 0);
        model.addAttribute("adicional", adicional);
        return "crear_adicional";
    }

    @PostMapping("/create")
    public String crearComida(Model model, Adicional adicional) {
        adicionalService.add(adicional);
        return "redirect:/adicionales";
    }

    @PostMapping("/update")
    public String postMethodName(Model model, Adicional adicional) {
            adicionalService.update(adicional);
        
        return "redirect:/adicionales";
    }
    

    @GetMapping("/delete/{id}")
    public String eliminarAdicional(@PathVariable("id") int id) {
        adicionalService.deleteById(id);
        return "redirect:/adicionales";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarAdicional(@PathVariable("id") int id, Model model) {
        model.addAttribute("adicional", adicionalService.SearchById(id));
        return "modificar_adicional";
    }
}
