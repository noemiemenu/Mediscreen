package com.mediscreen.web.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class PatientInfo {

    @NotBlank
    @Size(max = 1)
    private String sex;

    @NotBlank
    private int age;

    private List<String> notes;



    public PatientInfo(List<Note> notes, int age, String sex) {
        this.sex = sex;
        this.age = age;
        this.notes = notes.stream().map(Note::getE).collect(Collectors.toList());
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
