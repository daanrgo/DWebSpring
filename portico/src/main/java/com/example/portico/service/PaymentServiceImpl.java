// src/main/java/com/example/portico/service/PaymentServiceImpl.java

package com.example.portico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portico.entidad.PaymentType;
import com.example.portico.repositorio.PaymentTypeRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> findAll() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType findById(Integer id) {
        Optional<PaymentType> optional = paymentTypeRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public PaymentType save(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    @Override
    public void deleteById(Integer id) {
        paymentTypeRepository.deleteById(id);
    }
}
