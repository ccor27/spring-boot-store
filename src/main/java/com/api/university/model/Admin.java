package com.api.university.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ADMINS")
public class Admin extends Person{

    private User user;

    public Admin(String name, String lastName, String email, User user) {
        super(name, lastName, email);
        this.user = user;
    }
    public Admin(String name, String lastName, String email){
        super(name, lastName, email);
    }
    public Admin(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
