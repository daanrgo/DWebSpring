// src/main/java/com/example/portico/controlador/BillRestController.java
package com.example.portico.controlador;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.portico.entidad.Bill;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.service.BillService;

@RestController
@RequestMapping("/api/bill")
@CrossOrigin(origins = "*")
public class BillRestController {

    @Autowired
    private BillService billService;

    @GetMapping("")
    public Collection<Bill> getAllBills() {
        return billService.SearchAll();
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Integer id) {
        return billService.SearchById(id);
    }

    @PostMapping("")
    public void createBill(@RequestBody BillWithOrdersDTO billDTO) {
        billService.add(billDTO.getBill(), billDTO.getClientId(), billDTO.getOrders());
    }

    @PutMapping("/{id}")
    public void updateBill(@PathVariable Integer id, @RequestBody Bill bill) {
        bill.setId(id);
        billService.update(bill);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Integer id) {
        billService.deleteById(id);
    }

    @PutMapping("/{id}/assign-courier/{courierId}")
    public Bill assignCourier(@PathVariable Integer id, @PathVariable Integer courierId) {
        return billService.asignarRepartidor(id, courierId);
    }

    @PutMapping("/{id}/status/{status}")
    public Bill updateBillStatus(@PathVariable Integer id, @PathVariable Integer status) {
        return billService.actualizarEstadoPedido(id, status);
    }

    public static class BillWithOrdersDTO {
        private Bill bill;
        private int clientId;
        private List<OrderEntity> orders;

        public Bill getBill() {
            return bill;
        }

        public void setBill(Bill bill) {
            this.bill = bill;
        }

        public int getClientId() {
            return clientId;
        }

        public void setClientId(int clientId) {
            this.clientId = clientId;
        }

        public List<OrderEntity> getOrders() {
            return orders;
        }

        public void setOrders(List<OrderEntity> orders) {
            this.orders = orders;
        }
    }
}
