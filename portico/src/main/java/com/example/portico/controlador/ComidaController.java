package com.example.portico.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portico.dto.CarritoDTO;
import com.example.portico.dto.DTOIdUsuarioComida;
import com.example.portico.dto.DTOIdUsuarioComidas;
import com.example.portico.entidad.Adicional;
import com.example.portico.entidad.Comida;
import com.example.portico.service.AdicionalService;
import com.example.portico.service.ComidaService;


@RequestMapping("/comidas/{user_id}")

@Controller
public class ComidaController {

    @Autowired
    ComidaService comidaService;
    
    @Autowired 
    AdicionalService adicionalService;

    @GetMapping("")
    public String mostrarInfoComida(Model model, @PathVariable("user_id") int user_id) {
        DTOIdUsuarioComidas dto = new DTOIdUsuarioComidas(user_id, 
            comidaService.convertComidasToDTOList(comidaService.searchAll()));
        model.addAttribute("dto", dto);
        return "tabla_comida";
    }

    @GetMapping("/carrito")
    public String mostrarCarrito(Model model) {
        return "carrito_productos";
    }

    @GetMapping("/tarjetas")
    public String mostraHamburguesas(Model model, @PathVariable("user_id") int user_id) {
        DTOIdUsuarioComidas dto = new DTOIdUsuarioComidas(user_id, 
            comidaService.convertComidasToDTOList(comidaService.searchAll()));
        model.addAttribute("dto", dto);
        return "tarjetas_comidas";
    }

    @GetMapping("/{id}/adicionales")
    public String mostrarFormularioAdicionales(Model model, @PathVariable("id") int id) {
        Comida comida = comidaService.searchById(id);
        model.addAttribute("adicionalesDTO", comida.getAdicionalesSeleccionados());
        return "comida_individual_adicionales";
    }

    @PostMapping("/add_adicionales")
    public String agregarAdicionales(
            Model model, 
            @ModelAttribute("comida") Comida comidaRecibida, 
            @PathVariable("user_id") int user_id) {
        Comida comida = comidaService.searchById(comidaRecibida.getId());
        comida.setAdicionalesSeleccionados(comidaRecibida.getAdicionalesSeleccionados());
        comidaService.update(comida);
        return "redirect:/comidas/" + user_id + "/tarjetas";
    }

    @GetMapping("/{id}")
    public String verComida(Model model, @PathVariable("id") int id, @PathVariable("user_id") int user_id) {
        Comida comida = comidaService.searchById(id);
        DTOIdUsuarioComida dto = new DTOIdUsuarioComida(user_id, comidaService.convertToComidaDTO(comida));
        model.addAttribute("dto", dto);
        return "comida_individual";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model, @PathVariable("user_id") int user_id) {
        Comida comida = new Comida(0, "", 0, "", "");
        DTOIdUsuarioComida dto = new DTOIdUsuarioComida(user_id, comidaService.convertToComidaDTO(comida));
        model.addAttribute("comida", comida);
        return "crear_comida";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioModificar(Model model, 
                                           @PathVariable("id") int id, 
                                           @PathVariable("user_id") int user_id) {
        Comida comida = comidaService.searchById(id);
        model.addAttribute("comida", comida);
        return "modificar_comida";
    }

    @PostMapping("/create")
    public String crearComida(Model model, Comida comida, @PathVariable("user_id") int user_id) {
        System.out.println("Comida Recibida" + comida.toString());
        comidaService.add(comida);
        return "redirect:/comidas/" + user_id;
    }

    @GetMapping("/delete/{id}")
    public String eliminarComida(Model model, 
                               @PathVariable("id") int id, 
                               @PathVariable("user_id") int user_id) {
        comidaService.deleteById(id);
        return "redirect:/comidas/" + user_id;
    }

    @PostMapping("/update")
    public String actualizarComida(Model model, Comida comida, @PathVariable("user_id") int user_id) {
        List<Adicional> aux = comida.getAdicionales();
        comida.setAdicionales(new ArrayList<Adicional>());
        for(int i = 0; i < aux.size(); i++) {
            comida.addAdicional(adicionalService.SearchById(aux.get(i).getId()));
        }
        System.out.println("Comida Completa" + comida.toString());
        comidaService.update(comida);
        return "redirect:/comidas/" + user_id;
    }
}