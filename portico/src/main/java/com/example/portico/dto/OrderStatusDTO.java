// src/main/java/com/example/portico/dto/OrderstatusDTO.java

package com.example.portico.dto;

public class OrderStatusDTO {

    private Integer orderId;
    private Integer status;

    public OrderStatusDTO() {
    }

    public OrderStatusDTO(Integer orderId, Integer status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
} 
