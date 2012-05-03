package com.tutorial.resource;

import com.tutorial.view.EstimateView;
import com.tutorial.view.StoriesView;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/stories")
@Produces(MediaType.TEXT_HTML)
public class StoryResource {

    public StoryResource() {
    }

    @GET
    @Timed
    public StoriesView viewWall(){
        return new StoriesView();
    }

    @GET
    @Path("/new")
    public EstimateView createNewStory(){
        return new EstimateView();
    }

}
