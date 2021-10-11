package com.mediscreen.notes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * The type Note.
 */
@Document
public class Note {

    @Id
    private int id;

    @Field
    private int patId;

    @Field
    private String e;

    /**
     * Instantiates a new Note.
     */
    public Note() {

    }

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
