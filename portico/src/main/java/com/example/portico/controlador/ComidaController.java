package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.portico.entidad.Comida;

@Controller
@RequestMapping("/comida")
public class ComidaController {

    @Autowired
    private Comida comida;

    @GetMapping("/info")
    @ResponseBody 
    
    public String mostrarInfoComida(){
        return comida.toString();
   }
}
