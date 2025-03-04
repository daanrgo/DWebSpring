package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.portico.entidad.Comida;
import com.example.portico.service.ComidaService;

import org.springframework.ui.Model;



@RequestMapping("/comida")
@Controller
public class ComidaController {

    @Autowired
    ComidaService comidaService;

    @GetMapping("/info")
    public String mostrarInfoComida(Model model) {

        model.addAttribute("comidas", comidaService.SearchAll());
        return "tabla_comida";
    }

    @GetMapping("/hamburguesas")
    public String mostraHamburguesas(Model model) {

        model.addAttribute("comidas", comidaService.SearchAll());
        return "tarjetas_comidas";
    }

    @GetMapping("/hamburguesas/{id}")
    public String getMethodName(Model model, @PathVariable("id") int id) {
        model.addAttribute("comidas", comidaService.SearchById(id));
        return "tarjetas_comidas";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Comida comida = new Comida(0, "", 0, "", "");
        model.addAttribute("comida", comida);
        return "crearComida";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioModificar(Model model, @PathVariable("id") int id) {
        Comida comida = comidaService.SearchById(id);

        model.addAttribute("comida", comida);
        return "modificarComida";
    }
    

    @PostMapping("/create")
    public String crearComida(Model model, Comida comida){
        comidaService.add(comida);
        return "redirect:/comida/info";
    }

    @GetMapping("/delete/{id}")
    public String eliminarComida(Model model, @PathVariable("id") int id){
        comidaService.deleteById(id);
        return "redirect:/comida/info";
    }

   @PostMapping("/update")
   public String postMethodName(Model model, Comida comida) {
        System.out.println(comida.toString());
       comidaService.update(comida);
       return "redirect:/comida/info";
   }

}