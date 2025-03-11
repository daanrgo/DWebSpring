package com.example.portico.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LandingController {

    // http://localhost::8090/landing/hola
    @GetMapping("")
    public String landing(){
        return "landing";
    }

     @GetMapping("/somos")
    public String mostrarQuienesSomos() {
        return "somos";
    }
}
