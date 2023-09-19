package com.trackingmore.utils;

public class StrUtils {
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).trim().isEmpty();
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj);
        }
        if (obj instanceof Integer) {
            return ((Integer) obj) == 0;
        }
        return false;
    }
}
