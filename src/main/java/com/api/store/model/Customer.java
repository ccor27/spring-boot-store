package com.api.store.model;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Customer extends Person{

    private String email;
    @Column(length = 12)
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    private Record record;
    private String username;
    private String pwd;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(mappedBy = "id")
    private Set<Role> roles;


    public Customer() {}

    public Customer(String name, String lastName, String email, String phone, String username, String pwd, Address address, Set<Role> roles) {
        super(name, lastName);
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.pwd = pwd;
        this.address = address;
        this.roles = roles;
        this.record = new Record();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
