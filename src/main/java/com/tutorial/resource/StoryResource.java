package com.tutorial.resource;

import com.tutorial.core.Story;
import com.tutorial.view.EstimateView;
import com.tutorial.view.StoriesView;
import com.yammer.metrics.annotation.Timed;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stories")
@Produces(MediaType.TEXT_HTML)
public class StoryResource {

    private JacksonDBCollection<Story, String> stories;

    public StoryResource(JacksonDBCollection<Story, String> stories) {
        this.stories = stories;
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

    @POST
    @Path("/new")
    public Response createNewStory(@FormParam("title") String title, @FormParam("estimate") String estimate){
        stories.insert(new Story(title, estimate));

        return Response.noContent().build();
    }

}
