package com.cic_challenge.film_locator.service;

import com.cic_challenge.film_locator.config.Constants;
import com.cic_challenge.film_locator.model.Film;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;


@ApplicationScoped
@Path("/FilmLocatorService")
public class FilmLocatorResource {

    @Inject
    private FilmLocatorService filmLocatorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/films")
    public List<Film> getFilms(@QueryParam(Constants.PARAM_TITLE) String title,
                               @QueryParam(Constants.PARAM_LOCATIONS) String location) {
        return filmLocatorService.getAllFilms(title, location);
    }

}
