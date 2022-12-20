package com.api.university.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "COURSES")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "course")
    private List<Subject> subjects;
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "rel_course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
    private boolean isApprove;

    public Course(String name, boolean isApprove) {
        this.name = name;
        this.isApprove = isApprove;
    }

    public Course(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean isApprove() {
        // hacer un metodo que mire si todas las asignaturas estan aprovadas, si no estan aprovadas retorna false
        for (Subject subject:subjects ) {
            if(subject.getFinalNote()<12)
            {
                isApprove=false;
                break;
            }
        }
        return isApprove;
    }

    public void setApprove(boolean approve) {
        isApprove = approve;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
        for (int i=0;i<students.size();i++){
            if(students.get(i).getId()==student.getId()){
                students.remove(i);
            }
        }
        showStudents();
    }

    private void showStudents(){
        for (Student student: students){
            System.out.println(student);
        }
    }
}
