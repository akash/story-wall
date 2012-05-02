package com.tutorial.core;

import javax.persistence.Id;

public class Story {
    @Id
    private String id;
    private String name;
    private String estimate;

    public Story(){ /* required for serialization */
    }

    public Story(String name, String estimate) {
        this.name = name;
        this.estimate = estimate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEstimate() {
        return estimate;
    }
}