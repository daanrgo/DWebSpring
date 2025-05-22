package com.example.portico.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.portico.repositorio.AdicionalRepository;
import com.example.portico.repositorio.ClienteRepository;
import com.example.portico.repositorio.ComidaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    ComidaRepository comidaRepository;

    @Autowired
    AdicionalRepository adicionalRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Comida comida = Comida.builder()
            .name("Hamburguesa con queso")
            .price(800)
            .description("Hamburguesa clásica con carne y queso fundido.")
            .imagen("/images/burger2.png")
            .build();

        Adicional queso1 = new Adicional("Queso", 200);
        Adicional tocino = new Adicional("Tocino", 300);
        comida.addAdicional(queso1);
        comida.addAdicional(tocino);
        comidaRepository.save(comida);

        Comida comida2 = Comida.builder()
            .name("Hamburguesa BBQ")
            .price(950)
            .description("Hamburguesa BBQ ahumada con tocino crujiente y queso cheddar.")
            .imagen("/images/burger3.png")
            .build();

        Adicional queso2 = new Adicional("Queso", 200);
        Adicional aguacate1 = new Adicional("Aguacate", 250);
        comida2.addAdicional(queso2);
        comida2.addAdicional(aguacate1);
        comidaRepository.save(comida2);

        Comida comida3 = Comida.builder()
            .name("Hamburguesa de pepperoni")
            .price(1200)
            .description("Pizza clásica cubierta con pepperoni y mozzarella.")
            .imagen("/images/burger4.png")
            .build();

        Adicional queso3 = new Adicional("Queso", 200);
        Adicional aguacate2 = new Adicional("Aguacate", 250);
        comida3.addAdicional(queso3);
        comida3.addAdicional(aguacate2);
        comidaRepository.save(comida3);

        Comida comida4 = Comida.builder()
            .name("Hamburguesa hawaiana")
            .price(1300)
            .description("Deliciosa combinación de jamón y piña.")
            .imagen("/images/burger5.png")
            .build();

        Adicional jamon = new Adicional("Jamón", 280);
        Adicional pina = new Adicional("Piña", 160);
        comida4.addAdicional(jamon);
        comida4.addAdicional(pina);
        adicionalRepository.save(jamon);
        adicionalRepository.save(pina);
        comidaRepository.save(comida4);

        Comida comida5 = Comida.builder()
            .name("Hamburguesa Teriyaki")
            .price(1050)
            .description("Bañada en salsa teriyaki, con piña a la parrilla.")
            .imagen("/images/burger6.png")
            .build();

        Adicional jalapenos = new Adicional("Jalapeños", 120);
        Adicional aguacate3 = new Adicional("Aguacate", 250);
        comida5.addAdicional(jalapenos);
        comida5.addAdicional(aguacate3);
        comidaRepository.save(comida5);

        clienteRepository.save(new Cliente("Pepe123", "1234", "Pepe", "Gonzalez", "pepegonzalez@gmail.com", "31531977", "calle 34 av 25"));
        clienteRepository.save(new Cliente("Pepe1234", "12345", "Pepe", "Gonzalez2", "pepegonzalez2@gmail.com", "31531977", "calle 34 av 25"));
        clienteRepository.save(new Cliente("Pepe1235", "12345", "Pepe", "Gonzalez3", "pepegonzalez3@gmail.com", "31531977", "calle 34 av 25"));
        clienteRepository.save(new Cliente("Pepe1236", "12345", "Pepe", "Gonzalez4", "pepegonzalez4@gmail.com", "31531977", "calle 34 av 25"));
    }
}
