package com.trackingmore.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static <T> String convertToQueryString(T obj) {
        if (obj == null) {
            return "";
        }

        List<String> keyValuePairs = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);

                if (jsonProperty != null && value != null && !StrUtils.isEmpty(value)) {
                    keyValuePairs.add(jsonProperty.value() + "=" + value.toString());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return String.join("&", keyValuePairs);
    }
}
