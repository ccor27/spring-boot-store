package com.api.university.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @OneToOne
    @JoinColumn(name = "teacher_id")
    @JsonManagedReference
    private Teacher teacher;

    @JoinTable(
            name = "REL_STUDENTS_SUBJECTS",
            joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Student> students;

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Subject(){}

    public void addStudent(Student student){
        this.students.add(student);
    }
    public void deleteStudent(Student student){
        this.students.remove(student);
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teacher=" + teacher.getName() +
                '}';
    }
}
