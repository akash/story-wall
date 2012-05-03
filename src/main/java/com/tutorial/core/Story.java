package com.tutorial.core;

import net.vz.mongodb.jackson.Id;

public class Story {

    public enum State{
        backlog,
        inProgress,
        done
    }
    @Id
    private String id;
    private String title;
    private String estimate;
    private State state;

    public Story() {
        /* for serialization*/
    }

    public Story(String title, String estimate, State state) {
        this.title = title;
        this.estimate = estimate;
        this.state = state;
    }


    public String getTitle() {
        return title;
    }

    public String getEstimate() {
        return estimate;
    }
}
