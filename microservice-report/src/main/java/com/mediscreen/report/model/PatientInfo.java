package com.mediscreen.report.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The type Patient info.
 */
public class PatientInfo {


    private int id;

    @NotBlank
    @Size(max = 1)
    private String sex;

    private int age;

    private List<String> notes;

    /**
     * Instantiates a new Patient info.
     *
     * @param sex   the sex
     * @param age   the age
     * @param notes the notes
     */
    public PatientInfo(String sex, int age, List<String> notes) {
        this.sex = sex;
        this.age = age;
        this.notes = notes;
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
}
