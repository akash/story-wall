package com.tutorial.core;

import net.vz.mongodb.jackson.Id;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.GeneratedValue;

public class Story {
    public State getState() {
        return state;
    }

    public enum State{
        backlog,
        inProgress,
        done
    }

    @Id @GeneratedValue
    private String id;
    private String name;
    private String estimate;
    private State state;

    public Story(){ /* required for serialization */
    }

    public Story(@JsonProperty String name, @JsonProperty String estimate, @JsonProperty State state) {
        this.name = name;
        this.estimate = estimate;
        this.state = state;
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

    public void setState(State state) {
        this.state = state;
    }
}