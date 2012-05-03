package com.tutorial.core;

import net.vz.mongodb.jackson.Id;

public class Story {

    @Id
    private String id;
    private String title;
    private String estimate;

    public Story() {
        /* for serialization*/
    }

    public Story(String title, String estimate) {

        this.title = title;
        this.estimate = estimate;
    }


    public String getTitle() {
        return title;
    }

    public String getEstimate() {
        return estimate;
    }
}
