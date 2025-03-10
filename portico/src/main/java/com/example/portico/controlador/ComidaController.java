package com.example.portico.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.portico.entidad.AdicionalesDTO;
import com.example.portico.entidad.Comida;
import com.example.portico.service.ComidaService;

import org.springframework.ui.Model;

@RequestMapping("/comidas")
@Controller
public class ComidaController {

    @Autowired
    ComidaService comidaService;

    @GetMapping("")
    public String mostrarInfoComida(Model model) {

        model.addAttribute("comidas", comidaService.SearchAll());
        return "tabla_comida";
    }

    @GetMapping("/tarjetas")
    public String mostraHamburguesas(Model model) {

        model.addAttribute("comidas", comidaService.SearchAll());
        return "tarjetas_comidas";
    }

    @GetMapping("/{id}/adicionales")
    public String mostrarFormularioAdicionales(Model model, @PathVariable("id") int id) {
        Comida comida = comidaService.SearchById(id);

        model.addAttribute("adicionalesDTO", comida.getAdicionales());

        return "comida_individual_adicionales";
    }

    @PostMapping("/add_adicionales")
    public String agregarAdicionales(
            Model model, AdicionalesDTO adicionalesDTO
            ) {
        System.out.println(adicionalesDTO.getComidaId());
        Comida comida = comidaService.SearchById(adicionalesDTO.getComidaId());
        comida.setAdicionalesSeleccionados(adicionalesDTO.getAdicionalesSeleccionados());
        comidaService.update(comida);
        return "redirect:/comidas/" + comida.getId();
    }

    @GetMapping("/{id}")
    public String verComida(Model model, @PathVariable("id") int id) {
        model.addAttribute("comida", comidaService.SearchById(id));
        return "comida_individual";
    }

    @GetMapping("/crear")
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
    public String crearComida(Model model, Comida comida) {
        comidaService.add(comida);
        return "redirect:/comida";
    }

    @GetMapping("/delete/{id}")
    public String eliminarComida(Model model, @PathVariable("id") int id) {
        comidaService.deleteById(id);
        return "redirect:/comida";
    }

    @PostMapping("/update")
    public String postMethodName(Model model, Comida comida) {
        System.out.println(comida.toString());
        comidaService.update(comida);
        return "redirect:/comida";
    }

}