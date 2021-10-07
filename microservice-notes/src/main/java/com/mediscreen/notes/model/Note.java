package com.mediscreen.notes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Note {

    @Id
    private int id;

    @Field
    private int patId;

    @Field
    private String e;

    public Note() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatId() {
        return patId;
    }

    public void setPatId(int patId) {
        this.patId = patId;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}
