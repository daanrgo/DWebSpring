// src/main/java/com/example/portico/controlador/BillRestController.java
package com.example.portico.controlador;

import com.example.portico.entidad.Bill;
import com.example.portico.entidad.OrderEntity;
import com.example.portico.service.BillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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

    @GetMapping("/cliente/{id}")
    public List<Bill> getBillsByClient(@PathVariable int id) {
        return billService.findByClientId(id);
    }

    @GetMapping("/courier/{id}")
    public List<Bill> getBillsByCourier(@PathVariable int id) {
        return billService.findByCourierId(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBill(@RequestBody BillWithOrdersDTO billDTO) {
        if (billDTO.getBill() != null && billDTO.getOrders() != null) {
            billService.add(billDTO.getBill(), billDTO.getClientId(), billDTO.getOrders());
        }
    }

    @PutMapping("/{id}")
    public void updateBill(@PathVariable Integer id, @RequestBody Bill bill) {
        bill.setId(id);
        billService.update(bill);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
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

    /**
     * DTO que encapsula la factura (bill), el ID del cliente,
     * y la lista de ordenes asociadas.
     */
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
