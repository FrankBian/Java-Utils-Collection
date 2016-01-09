package com.gansuer.http;

import com.google.gson.*;

import java.lang.reflect.Type;

public class StringConverter implements JsonSerializer<String>, JsonDeserializer<String> {

    public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null || src.equalsIgnoreCase("null")) {
            return new JsonPrimitive("");
        } else {
            return new JsonPrimitive(src.toString());
        }
    }

    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return json.getAsJsonPrimitive().getAsString();
    }
}