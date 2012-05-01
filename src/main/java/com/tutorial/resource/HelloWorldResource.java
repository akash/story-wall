package com.tutorial.resource;

import com.google.common.base.Optional;
import com.tutorial.core.Saying;
import com.yammer.metrics.annotation.Timed;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private JacksonDBCollection<Saying, String> sayings;

    public HelloWorldResource(JacksonDBCollection<Saying, String> sayings) {
        this.sayings = sayings;
    }

    @GET
    @Timed
    public Response sayHello(@QueryParam("name") Optional<String> name, @QueryParam("lang") Optional<String> lang) {


        DBCursor<Saying> result = sayings.find();
        Saying saying = null;

        if (!result.hasNext())
            saying = new Saying("", "Hello World!", "en");
        else
            saying = result.is("lang", lang.or("en")).next();

        if(saying == null)
        {
            return Response.status(NOT_FOUND).build();
        }

        return Response.ok(result.next().apply(name)).build();
    }
}