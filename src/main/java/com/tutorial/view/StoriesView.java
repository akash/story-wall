package com.tutorial.view;

import com.tutorial.core.Story;
import com.yammer.dropwizard.views.View;

import java.util.List;

public class StoriesView extends View {

    private Story newStory;
    private List<Story> backlogStories;

    public StoriesView(Story newStory, List<Story> backlogStories) {
        super("/wall.ftl");
        this.newStory = newStory;
        this.backlogStories = backlogStories;
    }

    public Story getNewStory() {
        return newStory;
    }

    public List<Story> getBacklogStories(){
        return backlogStories;
    }
}
