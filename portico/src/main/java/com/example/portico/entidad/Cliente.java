package com.example.portico.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private Integer phone;
    private String address;

    

    public Cliente(Integer id, String username, String password, String name, String lastName, String email,
            Integer phone, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone; 
        this.address = address;
    }


    
    public Cliente(String username, String password, String name, String lastName, String email, Integer phone,
            String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }



    public void setId(Integer id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public Integer getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    
}
