package com.wcs.poker.jsonconverter;

import com.google.gson.Gson;
import java.lang.reflect.Type;

public class JsonConverter<T> {

    private final Gson gson;
    private final Class<T> objectClass;
    private final Type type;

    public JsonConverter(Type type) {
        this.objectClass = null;
        this.type = type;
        this.gson = new Gson();
    }

    public JsonConverter(Class<T> objectClass) {
        this.type = null;
        this.objectClass = objectClass;
        this.gson = new Gson();
    }

    public T fromJson(String json) {
        if (objectClass != null) {
            return gson.fromJson(json, objectClass);
        } else {
            return gson.fromJson(json, type);
        }
    }

    public String toJson(T source) {
        return gson.toJson(source, objectClass);
    }

}
