package com.example.portico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portico.entidad.LoginForm;
import com.example.portico.service.ClienteService;

@RequestMapping("/login")

@Controller
public class LoginController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping("")
    public String loginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm("", ""));
        return "login";
    }

    @PostMapping("")
    public String login(@ModelAttribute LoginForm loginForm, Model model) {
        Integer id_autenticado = clienteService.login(loginForm.getUsername(), loginForm.getPassword());

        if (id_autenticado != -1) {
            return "redirect:/comidas/" + id_autenticado.toString() + "/tarjetas";
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login_error"; 
    }
}
