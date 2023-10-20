    package org.petstore.apiutils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static String convertToJson(Object obj){
        try {
           return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
