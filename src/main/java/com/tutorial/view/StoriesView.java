package com.tutorial.view;

import com.tutorial.core.Story;
import com.yammer.dropwizard.views.View;

import java.util.List;

public class StoriesView extends View {

    private List<Story> stories;
    private Story newStory;

    public StoriesView(List<Story> stories, Story newStory) {
        super("/wall.ftl");
        this.stories = stories;
        this.newStory = newStory;
    }

    public List<Story> getStories() {
        return stories;
    }

    public Story getNewStory() {
        return newStory;
    }
}
