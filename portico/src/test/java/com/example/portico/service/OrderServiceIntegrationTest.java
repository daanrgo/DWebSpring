package com.example.portico.service;

import com.example.portico.dto.OrderStatusDTO;
import com.example.portico.entidad.Bill;
import com.example.portico.entidad.Comida;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.repositorio.BillRepository;
import com.example.portico.repositorio.ComidaRepository;
import com.example.portico.repositorio.OrderEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderEntityRepository orderRepo;

    @Autowired
    private ComidaRepository comidaRepo;

    @Autowired
    private BillRepository billRepo;

    private Comida comida;
    private Bill factura;

    @BeforeEach
    void setUp() {
        comida = new Comida("Pizza", 18000, "Pizza Napolitana", "pizza.jpg");
        comida = comidaRepo.save(comida);

        factura = new Bill();
        factura.setAddress("Calle Falsa 123");
        factura.setStatus(1);
        factura.setCreationDate(new java.util.Date());
        factura = billRepo.save(factura);

        OrderEntity orden = new OrderEntity();
        orden.setComida(comida);
        orden.setBill(factura);
        orden.setQuantity(2);
        orderRepo.save(orden);
    }

    @Test
    void testObtenerTodosLosPedidos() {
        List<OrderEntity> pedidos = orderService.obtenerTodosLosPedidos();
        assertThat(pedidos).isNotEmpty();
    }


    @Test
    void testGuardarNuevoPedido() {
        OrderEntity nuevo = new OrderEntity();
        nuevo.setComida(comida);
        nuevo.setBill(factura);
        nuevo.setQuantity(5);

        OrderEntity guardado = orderService.guardarPedido(nuevo);
        assertThat(guardado.getId()).isNotNull();
        assertThat(orderRepo.findById(guardado.getId())).isPresent();
    }

    @Test
    void testEliminarPedido() {
        List<OrderEntity> pedidos = orderRepo.findAll();
        assertThat(pedidos).isNotEmpty();

        OrderEntity orden = pedidos.get(0);
        orderService.deleteById(orden.getId());

        assertThat(orderRepo.findById(orden.getId())).isNotPresent();
    }


    @Test
    void testBuscarPorFactura() {
        List<OrderEntity> pedidos = orderService.buscarPorFactura(factura);
        assertThat(pedidos).isNotEmpty();
        assertThat(pedidos.get(0).getBill()).isEqualTo(factura);
    }

    @Test
    void testBuscarPorComida() {
        List<OrderEntity> pedidos = orderService.buscarPorComida(comida);
        assertThat(pedidos).isNotEmpty();
        assertThat(pedidos.get(0).getComida()).isEqualTo(comida);
    }
}    
