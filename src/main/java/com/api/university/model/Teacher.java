package com.api.university.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "TEACHERS")
public class Teacher extends Person{

    private String degree;
    @Column(name = "institutional_email")
    private String institutionalEmail;
    @OneToOne(mappedBy = "teacher",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Subject subject;


    public Teacher(String name, String lastName, String email, String degree,String institutionalEmail) {
        super(name, lastName, email);
        this.degree = degree;
        this.institutionalEmail=institutionalEmail;
    }

    public Teacher(){}
    //@JsonIgnore
    @OneToOne
    @JoinColumn(name = "role",referencedColumnName = "id")
    private Role role;
    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "degree='" + degree + '\'' +
                ", institutionalEmail='" + institutionalEmail + '\'' +
                ", subject=" + subject.getName() +
                ", role=" + role +
                '}';
    }
}
