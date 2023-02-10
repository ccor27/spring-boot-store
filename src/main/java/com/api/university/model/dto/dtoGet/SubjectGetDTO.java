package com.api.university.model.dto.dtoGet;

public class SubjectGetDTO {

    private Long id;
    private String name;
    private Double noteOne;
    private Double noteTwo;
    private Double noteThree;
    private Double noteFour;
    private Double finalNote;

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
        return finalNote;
    }

    public void setFinalNote(Double finalNote) {
        this.finalNote = finalNote;
    }
}
