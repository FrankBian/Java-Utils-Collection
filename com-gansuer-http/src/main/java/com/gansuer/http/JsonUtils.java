package com.gansuer.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public abstract class JsonUtils {
	
	public final static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().registerTypeAdapter(String.class, new StringConverter()).create();

	public static String toJson(Object src) {
		return gson.toJson(src);
	}
	
	public static String toJson(Object src, Type objType) {
		return gson.toJson(src, objType);
	}

	public static <T> String toJson1(T obj) {
		Type type = new TypeToken<T>() {}.getType();
		return toJson(obj, type);
	}
	
	public static <T> T fromJson(String json, Type typeOfT) {
		return gson.fromJson(json, typeOfT);
	}


}
