package com.tutorial.view;

import com.yammer.dropwizard.views.View;

public class StoriesView extends View {

    public StoriesView() {
        super("/wall.ftl");
    }
}
