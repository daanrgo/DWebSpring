
// src/main/java/com/example/portico/controlador/PaymentTypeRestController.java

package com.example.portico.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.portico.entidad.PaymentType;
import com.example.portico.service.PaymentService;

@RestController
@RequestMapping("/api/payment-types")
public class PaymentRestController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("")
    public List<PaymentType> getAllPaymentTypes() {
        return new ArrayList<>(paymentService.findAll());
    }

    @GetMapping("/{id}")
    public PaymentType getPaymentTypeById(@PathVariable Integer id) {
        return paymentService.findById(id);
    }

    @PostMapping("")
    public PaymentType createPaymentType(@RequestBody PaymentType paymentType) {
        return paymentService.save(paymentType);
    }

    @PutMapping("/{id}")
    public PaymentType updatePaymentType(@PathVariable Integer id, @RequestBody PaymentType paymentType) {
        paymentType.setId(id);
        return paymentService.save(paymentType);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentType(@PathVariable Integer id) {
        paymentService.deleteById(id);
    }
}
