package com.sandbox.gateway.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * Created by diogogallo on 7/11/16.
 */
public class ObjectMapperFactory {
    private static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper()
                .registerModule(new Hibernate4Module());
    }

    public static ObjectMapper create() {
        return objectMapper;
    }
}