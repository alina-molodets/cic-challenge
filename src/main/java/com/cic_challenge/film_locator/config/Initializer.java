package com.cic_challenge.film_locator.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class Initializer {

    public static Map<String, String> getInitialConfiguration() {

        final Properties properties = new Properties();
        try (final InputStream stream = Initializer.class.getResourceAsStream("/application.properties")) {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.entrySet().stream().collect(
                Collectors.toMap(
                        e -> e.getKey().toString(),
                        e -> e.getValue().toString()
                )
        );
    }
}