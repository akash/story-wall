package com.tutorial.resource;

import com.tutorial.view.EstimateView;
import com.tutorial.view.StoriesView;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/estimate")
@Produces(MediaType.TEXT_HTML)
public class EstimateResource {

    public EstimateResource() {
    }

    @GET
    @Timed
    public EstimateView viewWall(){
        return new EstimateView();
    }

}
