package com.mediscreen.report.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class PatientInfo {


    private int id;

    @NotBlank
    @Size(max = 1)
    private String sex;

    private int age;

    private List<String> notes;

    public PatientInfo(String sex, int age, List<String> notes) {
        this.sex = sex;
        this.age = age;
        this.notes = notes;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
