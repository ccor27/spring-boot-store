package com.api.university.model;



import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "STUDENTS")
public class Student extends Person{

    private String institutionalEmail;
    private User user;
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public Student(String name, String lastName, String email, String institutionalEmail, User user, List<Course> courses) {
        super(name, lastName, email);
        this.institutionalEmail = institutionalEmail;
        this.user = user;
        this.courses = courses;
    }
    public Student() {}

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
