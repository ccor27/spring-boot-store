package com.api.university.model.dto.dtoGet;

import java.util.List;

public class StudentGetDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String institutionalEmail;
    private List<SubjectGetDTO> subjectDTOS;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
    }

    public List<SubjectGetDTO> getSubjectDTOS() {
        return subjectDTOS;
    }

    public void setSubjectDTOS(List<SubjectGetDTO> subjectDTOS) {
        this.subjectDTOS = subjectDTOS;
    }
}
