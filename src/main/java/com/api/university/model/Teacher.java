package com.api.university.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEACHERS")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class Teacher extends Person{

    private String institutionalEmail;
    private String degree;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "teacher")
    //@JsonManagedReference
    private List<Subject> subjects;

    public Teacher(String name, String lastName, String email, String institutionalEmail, String degree, User user, List<Subject> subjects) {
        super(name, lastName, email);
        this.institutionalEmail = institutionalEmail;
        this.degree = degree;
        this.user = user;
        this.subjects = subjects;
    }

    public Teacher(){}

    public String getInstitutionalEmail() {
        return institutionalEmail;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String data(){
        return "teacher: "+this.getName()+" subjects: "+subjectsNames();
    }
    private String subjectsNames(){
        String names = "";
        for (Subject subject: subjects) {
            names+=subject.getName()+" -";
        }
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;

        Teacher teacher = (Teacher) o;

        return institutionalEmail.equals(teacher.institutionalEmail);
    }

    @Override
    public int hashCode() {
        return institutionalEmail.hashCode();
    }
}
