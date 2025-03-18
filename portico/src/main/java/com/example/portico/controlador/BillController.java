package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portico.entidad.Bill;
import com.example.portico.service.BillService;

@RequestMapping("/pedidos")
@Controller
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("")
    public String mostrarInfoBillString(Model model) {
        model.addAttribute("bill", billService.SearchAll());
        return "tabla_pedidos";
    }


    
}
