package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portico.entidad.Adicional;
import com.example.portico.entidad.Comida;
import com.example.portico.service.AdicionalService;
import com.example.portico.service.ComidaService;

@RequestMapping("/adicionales")
@Controller
public class AdicionalesController {
    
    @Autowired
    AdicionalService adicionalService;



    @GetMapping("/info")
    public String mostrarInfoAdicionales(Model model) {

        model.addAttribute("adicionales", adicionalService.SearchAll());
        return "tabla_adicionales";
    }


    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Adicional adicional = new Adicional(0, "", 0);
        model.addAttribute("adicional", adicional);
        return "crearAdicional";
    }

    @PostMapping("/delete/{id}")
    public String eliminarAdicional(@PathVariable("id") int id){
        adicionalService.deleteById(id);
        return "redirect:/comida/info";
    }
    

}
