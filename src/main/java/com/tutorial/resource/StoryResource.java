package com.tutorial.resource;

import com.tutorial.view.StoriesView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/stories")
@Produces(MediaType.TEXT_HTML)
public class StoryResource {

    @GET
    public StoriesView viewWall(){
        return new StoriesView();
    }
}
