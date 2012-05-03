package com.tutorial.resource;

import com.google.common.base.Optional;
import com.tutorial.core.Saying;
import com.tutorial.repository.SayingRepository;
import com.yammer.metrics.annotation.Timed;

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
    private SayingRepository sayingRepository;

    public HelloWorldResource(SayingRepository sayingRepository) {
        this.sayingRepository = sayingRepository;
    }

    @GET
    @Timed
    public Response sayHello(@QueryParam("name") Optional<String> name, @QueryParam("lang") Optional<String> lang) {
        Saying saying = sayingRepository.findByLanguage(lang.or("en"));

        if(saying == null) {
            return Response.status(NOT_FOUND).build();
        }

        return Response.ok(new Output(saying.apply(name))).build();
    }

    public class Output{
        private Output(String text) {
            this.text = text;
        }

        public String text;
    }
}