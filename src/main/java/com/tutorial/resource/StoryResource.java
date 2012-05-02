package com.tutorial.resource;

import com.google.common.base.Optional;
import com.tutorial.core.Story;
import com.tutorial.view.CreateStoryView;
import com.tutorial.view.StoriesView;
import com.yammer.metrics.annotation.Timed;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.DBQuery;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.WriteResult;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

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
        DBCursor<Story> allStories = stories.find();
        Story newStory = null;
        if (newId.isPresent())
            newStory = stories.findOne(DBQuery.is("_id", new ObjectId(newId.get())));

        return new StoriesView(allStories.toArray(), newStory);
    }

    @GET
    @Path("/new")
    public CreateStoryView viewCreateStory(){
        return new CreateStoryView();
    }

    @POST
    @Path("/new")
    @Timed
    public Response createStory(@FormParam("story_name") String name, @FormParam("story_estimate") String estimate){
        WriteResult<Story,String> writeResult = stories.insert(new Story(name, estimate));
        return Response.seeOther(URI.create(String.format("/stories?new=%s", writeResult.getSavedId()))).build();
    }
}
