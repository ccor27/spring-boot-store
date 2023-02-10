package com.api.university.model;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TEACHERS")
public class Teacher extends Person{

    private String degree;
    private String institutionalEmail;
    @OneToOne
    private Subject subject;
    @OneToOne
    private User user;
    @OneToMany
    private List<Student> students;

    public Teacher(String name, String lastName, String email, String degree, String institutionalEmail, Subject subject, User user, List<Student> students) {
        super(name, lastName, email);
        this.degree = degree;
        this.institutionalEmail = institutionalEmail;
        this.subject = subject;
        this.user = user;
        this.students = students;
    }

    public Teacher() {

    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
