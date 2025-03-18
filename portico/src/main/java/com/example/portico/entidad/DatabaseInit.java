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


        adicionalRepository.save(new Adicional("Queso", 200));
        adicionalRepository.save(new Adicional("Tocino", 300));
        adicionalRepository.save(new Adicional("Aguacate", 250));
        adicionalRepository.save(new Adicional("Huevo", 150));
        adicionalRepository.save(new Adicional("Champiñones", 180));
        adicionalRepository.save(new Adicional("Jalapeños", 120));
        adicionalRepository.save(new Adicional("Cebollas", 100));
        adicionalRepository.save(new Adicional("Tomates", 130));
        adicionalRepository.save(new Adicional("Lechuga", 90));
        adicionalRepository.save(new Adicional("Pepinillos", 110));
        adicionalRepository.save(new Adicional("Pollo a la parrilla", 400));
        adicionalRepository.save(new Adicional("Hamburguesa de carne", 500));
        adicionalRepository.save(new Adicional("Salami", 350));
        adicionalRepository.save(new Adicional("Pavo", 370));
        adicionalRepository.save(new Adicional("Piña", 160));
        adicionalRepository.save(new Adicional("Jamón", 280));
        adicionalRepository.save(new Adicional("Aceitunas", 140));
        adicionalRepository.save(new Adicional("Salsa de ajo", 90));
        adicionalRepository.save(new Adicional("Salsa BBQ", 120));
        adicionalRepository.save(new Adicional("Aderezo Ranch", 100));

        String defaultImage = "https://www.elespectador.com/resizer/v2/ZQUGSWWM2BBZXHEPBPMRIWX46U.jpg?auth=fba19f13a18b1a314f32e083e9d0727fbbe153571721015b63a21613680c519e&width=920&height=613&smart=true&quality=60";
        comidaRepository.save(new Comida("Hamburguesa con queso", 800, "Hamburguesa clásica con carne y queso fundido.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa BBQ", 950, "Hamburguesa BBQ ahumada con tocino crujiente y queso cheddar.", defaultImage));
        comidaRepository.save(new Comida("Wrap de pollo", 750, "Wrap de pollo a la parrilla con lechuga, tomate y aderezo ranch.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de pepperoni", 1200, "Pizza clásica cubierta con pepperoni y mozzarella.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa hawaiana", 1300, "Deliciosa combinación de jamón y piña.", defaultImage));
        comidaRepository.save(new Comida("Bistec a la parrilla", 2200, "Bistec jugoso a la parrilla a la perfección.", defaultImage));
        comidaRepository.save(new Comida("Espaguetis a la boloñesa", 1300, "Pasta italiana tradicional con salsa de carne.", defaultImage));
        comidaRepository.save(new Comida("Ensalada César", 850, "Lechuga romana fresca con aderezo César y crutones.", defaultImage));
        comidaRepository.save(new Comida("Burrito de carne", 950, "Burrito relleno de carne, frijoles, arroz y queso.", defaultImage));
        comidaRepository.save(new Comida("Sándwich club", 850, "Sándwich de tres capas con pavo, tocino y tomate.", defaultImage));
        comidaRepository.save(new Comida("Papas fritas", 450, "Papas fritas doradas crujientes servidas con ketchup.", defaultImage));
        comidaRepository.save(new Comida("Pastel de chocolate", 650, "Pastel de chocolate rico y húmedo.", defaultImage));
        comidaRepository.save(new Comida("Batido", 500, "Batido espeso y cremoso en varios sabores.", defaultImage));
        comidaRepository.save(new Comida("Café helado", 450, "Café frío con leche y edulcorante.", defaultImage));
        comidaRepository.save(new Comida("Té verde", 400, "Té verde refrescante y saludable.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa Tex-Mex", 1000, "Con guacamole, jalapeños y queso pepper jack.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Cordero", 1100, "Carne de cordero con tzatziki y menta fresca.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa Vegana", 900, "Hecha con lentejas, nueces y especias, servida con aguacate.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa Teriyaki", 1050, "Bañada en salsa teriyaki, con piña a la parrilla.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Portobello", 950, "Champiñón portobello a la parrilla, queso suizo y rúcula.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Pavo Cranberry", 1000, "Pavo molido con salsa de arándanos y queso brie.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa Picante", 980, "Con salsa habanero, cebollas caramelizadas y queso cheddar picante.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa Clásica Doble", 1200, "Doble carne, doble queso, lechuga, tomate y salsa especial.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa con Huevo Frito", 920, "Con un huevo frito, tocino y queso americano.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Salmón", 1150, "Filete de salmón a la parrilla, eneldo y mayonesa de limón.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa Italiana", 1080, "Con mozzarella fresca, pesto y tomates secos.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Cerdo Desmenuzado", 1100, "Cerdo desmenuzado en salsa BBQ, ensalada de col y pepinillos.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa Griega", 1020, "Con aceitunas, queso feta, pepino y salsa tzatziki.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Atún", 1180, "Atún sellado, aguacate, jengibre y salsa de soja.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Pollo Cajún", 980, "Pollo marinado en especias cajún, lechuga y mayonesa de chipotle.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa con Cebolla Caramelizada", 950, "Cebolla caramelizada, queso suizo y mostaza Dijon.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Remolacha", 900, "Remolacha asada, queso de cabra y rúcula.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa con Champiñones Salteados", 970, "Champiñones salteados, queso provolone y ajo asado.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Camarones", 1200, "Camarones a la parrilla, aguacate y mayonesa de cilantro.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Calabaza", 930, "Calabaza asada, queso ricotta y espinacas.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa con Aguacate y Tocino", 1050, "Aguacate fresco, tocino crujiente y queso cheddar.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa Coreana", 1000, "Con kimchi, salsa gochujang y huevo frito.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Lentejas y Quinoa", 920, "Lentejas y quinoa, aguacate y salsa tahini.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa con Queso Azul", 980, "Queso azul, nueces y peras a la parrilla.", defaultImage));
        comidaRepository.save(new Comida("Hamburguesa de Pescado Blanco", 1150, "Pescado blanco a la parrilla, salsa tártara y ensalada de col.", defaultImage));



        Comida asociar = comidaRepository.findById(1).get();

        for(Adicional hw: adicionalRepository.findAll()) {

            hw.setComida(asociar);
            adicionalRepository.save(hw);
        }

        clienteRepository.save(new Cliente("Pepe123", "1234", "Pepe", "Gonzalez", "pepegonzalez@gmail.com", 31531977, "calle 34 av 25"));
        clienteRepository.save(new Cliente("Pepe1234", "12345", "Pepe", "Gonzalez2", "pepegonzalez2@gmail.com", 31531977, "calle 34 av 25"));
        clienteRepository.save(new Cliente("Pepe1235", "12345", "Pepe", "Gonzalez3", "pepegonzalez3@gmail.com", 31531977, "calle 34 av 25"));
        clienteRepository.save(new Cliente("Pepe1236", "12345", "Pepe", "Gonzalez4", "pepegonzalez4@gmail.com", 31531977, "calle 34 av 25"));
    
    }
}
