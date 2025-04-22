package com.example.portico.dto;

public class LoginDTO {

    private Integer id;
    private String role;

    public LoginDTO(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
