package com.tutorial.view;

import com.tutorial.core.Story;
import com.yammer.dropwizard.views.View;

public class StoriesView extends View {

    private Story newStory;

    public StoriesView(Story newStory) {
        super("/wall.ftl");
        this.newStory = newStory;
    }

    public Story getNewStory() {
        return newStory;
    }
}
