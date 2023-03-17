package com.api.store.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Customer extends Person implements UserDetails {

    private String email;
    @Column(length = 12)
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private Record record;
    private String username;
    private String pwd;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @ManyToMany(fetch = FetchType.EAGER)
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
        //this.record = new Record();
    }
    public Customer(String name, String lastName, String email, String phone, String username, String pwd,Set<Role> roles) {
        super(name, lastName);
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.pwd = pwd;
        this.roles = roles;
        //this.record = new Record();
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return (Collection<? extends GrantedAuthority>) roles.stream().map(role -> {
            return new SimpleGrantedAuthority(role.getAuthority());
        }).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
