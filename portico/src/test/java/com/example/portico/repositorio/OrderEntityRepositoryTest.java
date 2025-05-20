package com.example.portico.repositorio;

import com.example.portico.entidad.Bill;
import com.example.portico.entidad.Comida;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.entidad.PaymentType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
public class OrderEntityRepositoryTest {

    @Autowired
    private OrderEntityRepository orderRepo;

    @Autowired
    private ComidaRepository comidaRepo;

    @Autowired
    private BillRepository billRepo;

    @Autowired
    private PaymentTypeRepository paymentTypeRepo;

    private Comida comida;
    private Bill factura;

    @BeforeEach
    void setup() {
        comida = new Comida();
        comida.setName("Pizza");
        comida.setPrice(20000);
        comida.setDescription("Pizza Margarita");
        comida.setImagen("pizza.jpg");
        comida = comidaRepo.save(comida);

        PaymentType tipoPago = new PaymentType();
        tipoPago.setDescription("ContraEntrega");
        tipoPago = paymentTypeRepo.save(tipoPago);

        factura = new Bill();
        factura.setAddress("Calle 123");
        factura.setStatus(1);
        factura.setCreationDate(new Date());
        factura.setPayment_type(tipoPago);
        factura = billRepo.save(factura);

        OrderEntity orden = new OrderEntity();
        orden.setBill(factura);
        orden.setComida(comida);
        orden.setQuantity(3);
        orderRepo.save(orden);
    }

    @Test
    void shouldFindByBill() {
        List<OrderEntity> result = orderRepo.findByBill(factura);
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getBill()).isEqualTo(factura);
    }

    @Test
    void shouldFindByComida() {
        List<OrderEntity> result = orderRepo.findByComida(comida);
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getComida()).isEqualTo(comida);
    }

    @Test
    void shouldFindByBillAndComida() {
        List<OrderEntity> result = orderRepo.findByBillAndComida(factura, comida);
        assertThat(result).isNotEmpty();
    }

    @Test
    void shouldFindByQuantityGreaterThan() {
        List<OrderEntity> result = orderRepo.findByQuantityGreaterThan(1);
        assertThat(result).hasSizeGreaterThan(0);
    }

    @Test
    void shouldFindByQuantityBetween() {
        List<OrderEntity> result = orderRepo.findByQuantityBetween(1, 5);
        assertThat(result).hasSizeGreaterThan(0);
    }
}
    