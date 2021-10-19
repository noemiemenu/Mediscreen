package com.mediscreen.notes.config;

import com.mediscreen.notes.model.NoteCustomSequences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * The type Note next sequence service.
 */
@Service
public class NoteNextSequenceService {

    @Autowired
    private MongoOperations mongo;

    /**
     * Gets next sequence.
     *
     * @param seqName the seq name
     * @return the next sequence
     */
    public int getNextSequence(String seqName)
    {
        NoteCustomSequences counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                NoteCustomSequences.class);
        return counter.getSeq();
    }
}