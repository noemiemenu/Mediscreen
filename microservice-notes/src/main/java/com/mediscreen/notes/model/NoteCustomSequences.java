package com.mediscreen.notes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Note custom sequences.
 */
@Document(collection = "noteCustomSequences")
public class NoteCustomSequences {

    @Id
    private String id;
    private int seq;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets seq.
     *
     * @return the seq
     */
    public int getSeq() {
        return seq;
    }

    /**
     * Sets seq.
     *
     * @param seq the seq
     */
    public void setSeq(int seq) {
        this.seq = seq;
    }
}
