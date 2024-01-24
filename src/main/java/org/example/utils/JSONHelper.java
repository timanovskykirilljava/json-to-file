package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class JSONHelper {
    public static String prettifyJSON(JSONObject jsonObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object jsonObjectPretty = null;
        try {
            jsonObjectPretty = objectMapper.readValue(jsonObject.toString(), Object.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String prettyJson;
        try {
            prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObjectPretty);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return prettyJson;
    }
}
