package com.tutorial.repository;

import com.tutorial.core.Saying;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.DBQuery;
import net.vz.mongodb.jackson.JacksonDBCollection;

public class MongoSayingRepository implements SayingRepository {
    private JacksonDBCollection<Saying, String> sayingsCollection;

    public MongoSayingRepository(JacksonDBCollection<Saying, String> sayingsCollection) {
        this.sayingsCollection = sayingsCollection;
    }

    public Saying findByLanguage(String language) {
        DBCursor<Saying> sayings = sayingsCollection.find().is("lang", language);
        Saying saying = sayingsCollection.findOne(DBQuery.is("lang", language));


        return sayings.hasNext() ? sayings.next() : null;
    }
}
