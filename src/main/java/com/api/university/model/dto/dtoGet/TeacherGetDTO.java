package com.api.university.model.dto.dtoGet;

import java.util.List;

public class TeacherGetDTO {
    private Long id;
    private String name;
    private String lastName;
    private String degree;
    private String email;
    private String institutionalEmail;
    private SubjectGetDTO subjectDTO;
    private List<StudentGetDTO> studentDTOS;

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

    public SubjectGetDTO getSubjectDTO() {
        return subjectDTO;
    }

    public void setSubjectDTO(SubjectGetDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }

    public List<StudentGetDTO> getStudentDTOS() {
        return studentDTOS;
    }

    public void setStudentDTOS(List<StudentGetDTO> studentDTOS) {
        this.studentDTOS = studentDTOS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
