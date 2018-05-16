package com.cic_challenge.film_locator.service;

import com.cic_challenge.film_locator.config.Constants;
import com.cic_challenge.film_locator.config.Initializer;
import com.cic_challenge.film_locator.model.Film;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;


@ApplicationScoped
public class FilmLocatorService {

    public List<Film> getAllFilms(String title, String location) {
        String urlPath = Initializer.getInitialConfiguration().get(Constants.DATA_SOURCE_URL_PROPERTY_NAME);
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        return client.target(urlPath)
                .queryParam(Constants.PARAM_TITLE, title)
                .queryParam(Constants.PARAM_LOCATIONS, location)
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<Film>>() {
                });
    }
}
