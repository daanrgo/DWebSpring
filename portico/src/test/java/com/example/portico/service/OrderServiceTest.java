package com.example.portico.service;

import com.example.portico.entidad.Bill;
import com.example.portico.entidad.Comida;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.repositorio.OrderEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private OrderEntityRepository orderRepo;

    @InjectMocks
    private OrderServiceImpl orderService;

    private OrderEntity orden;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orden = new OrderEntity();
        orden.setId(1);
        orden.setQuantity(2);
    }

    @Test
    void testObtenerTodosLosPedidos() {
        when(orderRepo.findAll()).thenReturn(Arrays.asList(orden));
        List<OrderEntity> result = orderService.findAll();
        assertThat(result).hasSize(1);
        verify(orderRepo, times(1)).findAll();
    }

    @Test
    void testGuardarPedido() {
        orderService.save(orden);
        verify(orderRepo).save(orden);
    }

    @Test
    void testEliminarPedido() {
        orderService.deleteById(1);
        verify(orderRepo).deleteById(1);
    }

    @Test
    void testBuscarPorId() {
        when(orderRepo.findById(1)).thenReturn(java.util.Optional.of(orden));
        OrderEntity result = orderService.findById(1);
        assertThat(result).isEqualTo(orden);
    }

    @Test
    void testActualizarEstado() {
        Bill bill = new Bill();
        bill.setStatus(1);
        orden.setBill(bill);

        when(orderRepo.findById(1)).thenReturn(java.util.Optional.of(orden));
        orderService.updateStatus(1, 2);

        assertThat(orden.getBill().getStatus()).isEqualTo(2);
        verify(orderRepo).save(orden);
    }
}
