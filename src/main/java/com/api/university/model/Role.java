package com.api.university.model;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Role  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    public Role(Long id, String role_name) {
        this.id = id;
        this.roleName = role_name;
    }
    public Role(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
