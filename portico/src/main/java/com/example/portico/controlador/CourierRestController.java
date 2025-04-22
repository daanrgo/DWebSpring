
package com.example.portico.controlador;

import com.example.portico.entidad.Courier;
import com.example.portico.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/couriers")
@CrossOrigin(origins = "http://localhost:4200")
public class CourierRestController {

    @Autowired
    private CourierService courierService;

    @GetMapping("")
    public List<Courier> getAllCouriers() {
        return new ArrayList<>(courierService.searchAll());
    }

    @GetMapping("/{id}")
    public Courier getCourierById(@PathVariable("id") int id) {
        return courierService.searchById(id);
    }

    @PostMapping("/create")
    public Courier createCourier(@RequestBody Courier courier) {
        courierService.add(courier);
        return courier;
    }

    @PutMapping("/update/{id}")
    public Courier updateCourier(@PathVariable("id") int id, @RequestBody Courier courier) {
        courier.setId(id);
        courierService.update(courier);
        return courier;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourier(@PathVariable("id") int id) {
        courierService.deleteById(id);
    }
}

