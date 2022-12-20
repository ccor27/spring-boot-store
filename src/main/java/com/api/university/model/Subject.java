package com.api.university.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUBJECT")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double noteOne;
    private Double noteTwo;
    private Double noteThree;
    private Double noteFour;
    private Double finalNote;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Course course;
    @ManyToOne(cascade = CascadeType.REFRESH)
    //@JsonBackReference
    private Teacher teacher;

    public Subject(String name, String description, Double noteOne, Double noteTwo, Double noteThree, Double noteFour, Double finalNote, Course course, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.noteOne = noteOne;
        this.noteTwo = noteTwo;
        this.noteThree = noteThree;
        this.noteFour = noteFour;
        this.finalNote = finalNote;
        this.course = course;
        this.teacher = teacher;
    }
    public Subject(){}

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

    public Double getNoteOne() {
        return noteOne;
    }

    public void setNoteOne(Double noteOne) {
        this.noteOne = noteOne;
    }

    public Double getNoteTwo() {
        return noteTwo;
    }

    public void setNoteTwo(Double noteTwo) {
        this.noteTwo = noteTwo;
    }

    public Double getNoteThree() {
        return noteThree;
    }

    public void setNoteThree(Double noteThree) {
        this.noteThree = noteThree;
    }

    public Double getNoteFour() {
        return noteFour;
    }

    public void setNoteFour(Double noteFour) {
        this.noteFour = noteFour;
    }

    public Double getFinalNote() {
        this.finalNote = (noteOne+noteTwo+noteThree+noteFour)/4;
        return finalNote;
    }

    public void setFinalNote(Double finalNote) {
        this.finalNote = finalNote;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



}
