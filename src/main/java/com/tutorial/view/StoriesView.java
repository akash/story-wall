package com.tutorial.view;

import com.tutorial.core.Story;
import com.yammer.dropwizard.views.View;

import java.util.List;

public class StoriesView extends View {

    private List<Story> doneStories;
    private List<Story> inProgressStories;
    private List<Story> backlogStories;
    private Story newStory;

    public StoriesView(List<Story> backlogStories, List<Story> inProgressStories, List<Story> doneStories, Story newStory) {
        super("/wall.ftl");
        this.doneStories = doneStories;
        this.inProgressStories = inProgressStories;
        this.backlogStories = backlogStories;
        this.newStory = newStory;
    }

    public List<Story> getBacklogStories() {
        return backlogStories;
    }

    public List<Story> getInProgressStories() {
        return inProgressStories;

    }

    public List<Story> getDoneStories() {
        return doneStories;
    }

    public Story getNewStory() {
        return newStory;
    }
}
