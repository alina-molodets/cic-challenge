package com.cic_challenge.film_locator.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class Initializer {

    public static Logger logger = LoggerFactory.getLogger(Initializer.class);


    public static Map<String, String> getInitialConfiguration() {

        final Properties properties = new Properties();
        try (final InputStream stream = Initializer.class.getResourceAsStream(Constants.APPLICATION_PROPERTIES_FILE_PATH)) {
            properties.load(stream);
        } catch (IOException e) {
            logger.error("Error during reading properties file occured {}", e);
        }
        return properties.entrySet().stream().collect(
                Collectors.toMap(
                        e -> e.getKey().toString(),
                        e -> e.getValue().toString()
                )
        );
    }
}