// src/main/java/com/example/portico/controlador/OrderRestController.java

package com.example.portico.controlador;

import com.example.portico.dto.DTOIdUsuarioComidas;
import com.example.portico.dto.OrderStatusDTO;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.service.BillService;
import com.example.portico.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BillService billService;

    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable int id) {
        return orderService.findById(id);
    }

    @GetMapping("/status")
    public List<OrderStatusDTO> getAllOrdersWithEstado() {
        return orderService.findAllConEstado();
    }

    @PostMapping("/create")
    public OrderEntity createOrder(@RequestBody OrderEntity order) {
        orderService.save(order);
        return order;
    }

    @PostMapping("/create-order")
    public ResponseEntity<Map<String, String>> createOrderFromDTO(@RequestBody DTOIdUsuarioComidas dto) {
        try {
            billService.crearFacturaDesdePedido(dto);
            return ResponseEntity.ok(Map.of("message", "Pedido creado exitosamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Error al procesar el pedido: " + e.getMessage()));
        }
    }
    

    @PutMapping("/update/{id}")
    public OrderEntity updateOrder(@PathVariable int id, @RequestBody OrderEntity order) {
        order.setId(id);
        orderService.save(order);
        return order;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteById(id);
    }

    @PutMapping("/update-status")
    public ResponseEntity<String> actualizarEstado(@RequestBody OrderStatusDTO dto) {
        try {
            orderService.updateStatus(dto.getOrderId(), dto.getStatus());
            return ResponseEntity.ok("Estado actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
}
