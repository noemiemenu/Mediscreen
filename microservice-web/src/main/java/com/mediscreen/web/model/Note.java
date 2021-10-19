package com.mediscreen.web.model;

import java.io.Serializable;

/**
 * The type Note.
 */
public class Note implements Serializable {

    /**
     * id of note
     */
    private int id;

    /**
     * id of Patient
     */
    private int patId;

    /**
     * note of doctor
     */
    private String e;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets pat id.
     *
     * @return the pat id
     */
    public int getPatId() {
        return patId;
    }

    /**
     * Sets pat id.
     *
     * @param patId the pat id
     */
    public void setPatId(int patId) {
        this.patId = patId;
    }

    /**
     * Gets e.
     *
     * @return the e
     */
    public String getE() {
        return e;
    }

    /**
     * Sets e.
     *
     * @param e the e
     */
    public void setE(String e) {
        this.e = e;
    }
}
