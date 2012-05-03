package com.tutorial.resource;

import com.google.common.base.Optional;
import com.tutorial.core.Story;
import com.tutorial.view.CreateStoryView;
import com.tutorial.view.StoriesView;
import com.yammer.metrics.annotation.Timed;
import net.vz.mongodb.jackson.DBQuery;
import net.vz.mongodb.jackson.DBUpdate;
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
        List<Story> backlogStories = stories.find().in("state", Story.State.backlog).toArray();
        List<Story> inProgressStories = stories.find().in("state", Story.State.inProgress).toArray();
        List<Story> doneStories = stories.find().in("state", Story.State.done).toArray();
        Story newStory = null;
        if (newId.isPresent())
            newStory = stories.findOne(DBQuery.is("_id", new ObjectId(newId.get())));

        return new StoriesView(backlogStories, inProgressStories, doneStories, newStory);
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
        WriteResult<Story,String> writeResult = stories.insert(new Story(name, estimate, Story.State.backlog));
        return Response.seeOther(URI.create(String.format("/stories?new=%s", writeResult.getSavedId()))).build();
    }

    @POST
    @Path("/{id}/change-column")
    @Timed
    public Response changeColumn(@PathParam("id") String id, @FormParam("column")String column){
        stories.update(DBQuery.is("_id", new ObjectId(id)), DBUpdate.set("state", column));
        return Response.noContent().build();
    }

}
