package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.portico.entidad.Comida;
import com.example.portico.service.ComidaService;

import org.springframework.ui.Model;

@RequestMapping("/comida")
@Controller
public class ComidaController {

    @Autowired
    ComidaService comidaService;

    @GetMapping("/info")    
    public String mostrarInfoComida(Model model){

        model.addAttribute("comidas",comidaService.SearchAll());
        return "tabla_comida";
   }


}
