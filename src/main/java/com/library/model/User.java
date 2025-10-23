package com.library.model;

import java.time.LocalDate;

public class User {

    private long id; // Para mapear a chave primária da tabela
    private String name;
    private String contact; // Mapeia o 'login' ou identificador primário
    private String password;
    private String role; // Mapeia o 'perfil' (adm ou user)
    private LocalDate registrationDate;
    private boolean isActive;

    // Construtor completo para uso em leituras do banco de dados (DAO)
    public User(long id, String name, String contact, String password,
                   String role, LocalDate registrationDate, boolean isActive) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
        this.isActive = isActive;
    }

    // Construtor para novas inserções
    public User(String name, String contact, String password, String role) {
        this.name = name;
        this.contact = contact;
        this.password = password;
        this.role = role;
        this.registrationDate = LocalDate.now(); // Define a data atual
        this.isActive = true; // Define como ativo por padrão
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
