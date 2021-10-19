package com.mediscreen.web.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Patient info.
 */
public class PatientInfo {

    @NotBlank
    @Size(max = 1)
    private String sex;

    @NotBlank
    private int age;

    private List<String> notes;


    /**
     * Instantiates a new Patient info.
     *
     * @param notes the notes
     * @param age   the age
     * @param sex   the sex
     */
    public PatientInfo(List<Note> notes, int age, String sex) {
        this.sex = sex;
        this.age = age;
        this.notes = notes.stream().map(Note::getE).collect(Collectors.toList());
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    public List<String> getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     *
     * @param notes the notes
     */
    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
