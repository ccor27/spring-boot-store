package com.api.university.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "STUDENTS")
public class Student extends Person{
    @Column(name = "institutional_email")
    private String institutionalEmail;
    @ManyToMany(mappedBy = "students")
    @JsonBackReference
    private List<Subject> subjects;


    public Student(String name, String lastName, String email, String institutionalEmail) {
        super(name, lastName, email);
        this.institutionalEmail = institutionalEmail;
    }
    @OneToOne
    @JoinColumn(name = "role",referencedColumnName = "id")
    private Role role;

    public Student(){}

    public void addSubject(Subject subject){
        this.subjects.add(subject);
    }
    public void deleteSubject(Subject subject){
        this.subjects.remove(subject);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
