package com.example.portico.controller;

import com.example.portico.controlador.OrderRestController;
import com.example.portico.dto.OrderStatusDTO;
import com.example.portico.entidad.Bill;
import com.example.portico.entidad.Comida;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class OrderRestControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderRestController controller;

    private OrderEntity order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Bill bill = new Bill();
        bill.setStatus(1);

        Comida comida = new Comida("Hamburguesa", 15000, "con queso", "img.jpg");

        order = new OrderEntity();
        order.setId(1);
        order.setBill(bill);
        order.setComida(comida);
        order.setQuantity(2);
    }

    @Test
    void testFindAllOrders() {
        when(orderService.findAll()).thenReturn(Arrays.asList(order));
        List<OrderEntity> result = controller.getAllOrders();
        assertThat(result).hasSize(1);
    }

    @Test
    void testFindOrderById() {
        when(orderService.findById(1)).thenReturn(order);
        OrderEntity result = controller.getOrderById(1);
        assertThat(result).isEqualTo(order);
    }

    @Test
    void testSaveOrder() {
        doNothing().when(orderService).save(order);
        controller.createOrder(order);
        verify(orderService).save(order);
    }

    @Test
    void testDeleteOrder() {
        doNothing().when(orderService).deleteById(1);
        controller.deleteOrder(1);
        verify(orderService).deleteById(1);
    }

    @Test
    void testUpdateStatus() {
        OrderStatusDTO dto = new OrderStatusDTO(1, 2);
        doNothing().when(orderService).updateStatus(1, 2);
        ResponseEntity<String> result = controller.actualizarEstado(dto);
        verify(orderService).updateStatus(1, 2);
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
    }
}
