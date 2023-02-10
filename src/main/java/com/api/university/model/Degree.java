package com.api.university.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEGREES")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<Subject> subjects;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
