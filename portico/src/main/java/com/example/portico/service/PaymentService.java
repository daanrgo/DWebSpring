// src/main/java/com/example/portico/service/PaymentTypeService.java
package com.example.portico.service;

import java.util.Collection;

import com.example.portico.entidad.PaymentType;

public interface PaymentService {
    PaymentType findById(Integer id);
    Collection<PaymentType> findAll();
    PaymentType save(PaymentType paymentType);
    void deleteById(Integer id);
}
