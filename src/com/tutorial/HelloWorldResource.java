package com.tutorial;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final AtomicLong counter;
    private JacksonDBCollection<Saying, String> sayings;

    public HelloWorldResource(JacksonDBCollection<Saying, String> sayings) {
        this.sayings = sayings;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Response sayHello(@QueryParam("name") Optional<String> name, @QueryParam("lang") Optional<String> lang) {

        Saying saying = sayings.find().is("lang", lang.or("en")).next();
        if(saying == null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(saying.apply(name)).build();
    }
}