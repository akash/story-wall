package com.tutorial.resource;

import com.google.common.base.Optional;
import com.tutorial.core.Story;
import com.tutorial.view.EstimateView;
import com.tutorial.view.StoriesView;
import com.yammer.metrics.annotation.Timed;
import net.vz.mongodb.jackson.DBQuery;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.WriteResult;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/stories")
@Produces(MediaType.TEXT_HTML)
public class StoryResource {

    private JacksonDBCollection<Story, String> stories;

    public StoryResource(JacksonDBCollection<Story, String> stories) {
        this.stories = stories;
    }

    @GET
    @Timed
    public StoriesView viewWall(@QueryParam("new")Optional<String> newId){
        Story newStory = null;

        if (newId.isPresent())
            newStory = stories.findOne(DBQuery.is("_id", new ObjectId(newId.get())));

        List<Story> backlogStories = stories.find().toArray();
        return new StoriesView(newStory, backlogStories);
    }

    @GET
    @Path("/new")
    public EstimateView createNewStory(){
        return new EstimateView();
    }

    @POST
    @Path("/new")
    public Response createNewStory(@FormParam("title") String title, @FormParam("estimate") String estimate){
        WriteResult<Story,String> writeResult = stories.insert(new Story(title, estimate, Story.State.backlog));

        return Response.seeOther(URI.create(String.format("/stories?new=%s", writeResult.getSavedId()))).build();
    }

}
