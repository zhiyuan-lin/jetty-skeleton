package com.edsgerlin.jetty.skeleton;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;

@Path("point")
public class PointResource {
    @Inject
    private Point2DRepository point2dRepository;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPoints() {
        return String.join(", ",
        point2dRepository.findAll().stream().map(p -> p.toString()).collect(Collectors.toList()));
    }
}