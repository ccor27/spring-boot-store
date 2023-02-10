package com.api.university.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADMINS")
public class Admin extends Person{
    @Column(name = "_position")
    private String position;
    private String cellphone;
    private String email;
    @OneToOne
    private User user;

    public Admin(String name, String lastName, String email, String position, String cellphone, String email1, User user) {
        super(name, lastName, email);
        this.position = position;
        this.cellphone = cellphone;
        this.email = email1;
        this.user = user;
    }

    public Admin() { }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
