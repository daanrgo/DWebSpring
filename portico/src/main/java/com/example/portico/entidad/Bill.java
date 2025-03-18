package com.example.portico.entidad;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer status;
    private Date creationDate;
    private String address;


    @ManyToOne
    private Operator operator;

    @ManyToOne
    private Cliente client;    

    @ManyToOne
    private Courier courier;

    @ManyToOne
    private PaymentType payment_type;

    @OneToMany(mappedBy = "bill")
    private List<OrderEntity> orders;



    public Bill() {
    }

    public Bill(Integer status, Date creationDate, String email, Integer phone, String address) {
        this.status = status;
        this.creationDate = creationDate;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}