package com.api.university.model;



import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "STUDENTS")
public class Student extends Person{

    private String institutionalEmail;
    @OneToOne
    private User user;
    @OneToMany
    private List<Subject> subjects;

    public Student(String name, String lastName, String email, String institutionalEmail, User user, List<Subject> subjects) {
        super(name, lastName, email);
        this.institutionalEmail = institutionalEmail;
        this.user = user;
        this.subjects = subjects;
    }

    public Student() {
    }

    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
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
