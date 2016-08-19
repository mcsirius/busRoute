package com.goeuro.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HarryZ on 8/19/16.
 */
@Configuration
public class BeanConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(BeanConfiguration.class);

    @Value("${FILE.PATH}")
    private String filePath;

    @Bean
    public Map<Integer,Map<Integer, Integer>> routeMap() {

        Map<Integer,Map<Integer, Integer>> list = new HashMap<>();

        try {
            URI uri = new URI(filePath);
            File file = new File(uri);

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int numOfRoutes = Integer.parseInt(reader.readLine());

            String line;

            while ((line = reader.readLine()) != null) {
                String[] ids = line.split("\\s");
                Map<Integer, Integer> map = new HashMap<>();

                if (ids.length >= 2) {
                    int id = Integer.parseInt(ids[0]);
                    for (int i = 1; i < ids.length; i++) {
                        map.put(Integer.parseInt(ids[i]), i);
                    }
                    list.put(id, map);
                }
            }

        } catch (Exception ex) {
            LOG.error("Something went wrong during the initialization");
        }

        return list;
    }
}
