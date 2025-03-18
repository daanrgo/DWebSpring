package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.portico.entidad.Comida;
import com.example.portico.service.ComidaService;
import com.example.portico.dto.TarjetasComidaDTO;

import org.springframework.ui.Model;

@RequestMapping("/comidas/{user_id}")
@Controller
public class ComidaController {

    @Autowired
    ComidaService comidaService;

    @GetMapping("")
    public String mostrarInfoComida(Model model) {

        model.addAttribute("comidas", comidaService.SearchAll());
        return "tabla_comida";
    }

    @GetMapping("/carrito")
    public String mostrarCarrito(Model model){
        return "carrito";
    }

    @GetMapping("/tarjetas")
    public String mostraHamburguesas(Model model, @PathVariable("user_id") int user_id) {

        TarjetasComidaDTO dto = new TarjetasComidaDTO(user_id, comidaService.SearchAll());

        model.addAttribute("dto", dto);
        return "tarjetas_comidas";
    }

    @GetMapping("/{id}/adicionales")
    public String mostrarFormularioAdicionales(Model model, @PathVariable("id") int id) {
        Comida comida = comidaService.SearchById(id);

        model.addAttribute("adicionalesDTO", comida.getAdicionalesSeleccionados());

        return "comida_individual_adicionales";
    }

    @PostMapping("/add_adicionales")
    public String agregarAdicionales(
            Model model, Comida comidaRecibida
            ) {
        Comida comida = comidaService.SearchById(comidaRecibida.getId());
        comida.setAdicionalesSeleccionados(comidaRecibida.getAdicionalesSeleccionados());
        comidaService.update(comida);
        System.out.println("AdicionalesSlec");
        System.out.println(comidaRecibida.getAdicionalesSeleccionados().get(1));
        return "redirect:/comidas";
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
        return "crear_comida";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioModificar(Model model, @PathVariable("id") int id) {
        Comida comida = comidaService.SearchById(id);

        model.addAttribute("comida", comida);
        return "modificar_comida";
    }

    @PostMapping("/create")
    public String crearComida(Model model, Comida comida) {
        comidaService.add(comida);
        return "redirect:/comidas";
    }

    @GetMapping("/delete/{id}")
    public String eliminarComida(Model model, @PathVariable("id") int id) {
        comidaService.deleteById(id);
        return "redirect:/comidas";
    }

    @PostMapping("/update")
    public String postMethodName(Model model, Comida comida) {
        System.out.println(comida.toString());
        comidaService.update(comida);
        return "redirect:/comidas";
    }


    
}