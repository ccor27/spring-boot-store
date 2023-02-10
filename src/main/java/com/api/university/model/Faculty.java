package com.api.university.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FACULTIES")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "faculty")
    private List<Degree> degrees;
}
