package com.cic_challenge.film_locator.config;


import com.cic_challenge.film_locator.service.FilmLocatorService;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(FilmLocatorService.class).to(FilmLocatorService.class);
            }
        });
        register(JacksonJsonProvider.class);
        packages("com.cic_challenge.film_locator.service");
    }
}
