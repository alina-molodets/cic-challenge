package com.cic_challenge.film_locator.service;

import com.cic_challenge.film_locator.model.Film;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FilmLocatorResourceTest extends JerseyTest {

    private static final String FILM_TITLE = "any title";
    private static final String FILM_LOCATION = "any location";

    @Mock
    private FilmLocatorService service;

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig().register(FilmLocatorResource.class)
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(service).to(FilmLocatorService.class);
                    }
                });
    }

    @Test
    public void testGetAllFilms() {
        List<Film> expectedFilms = arrangeFilms();

        Response response = target("FilmLocatorService/films").request().get();
        List<Film> actualFilms = response.readEntity(new GenericType<List<Film>>() {
        });

        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals(expectedFilms, actualFilms);
    }

    private List<Film> arrangeFilms() {
        Film f = new Film(FILM_TITLE, FILM_LOCATION);
        List<Film> films = Arrays.asList(f);

        when(service.getAllFilms(any(), any())).thenReturn(films);
        return films;
    }
}
