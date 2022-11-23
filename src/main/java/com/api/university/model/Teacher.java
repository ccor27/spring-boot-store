package com.api.university.model;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEACHERS")
public class Teacher extends Person{

    private String institutionalEmail;
    private String degree;
    private User user;
    @OneToMany(mappedBy = "teacher")
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
}
