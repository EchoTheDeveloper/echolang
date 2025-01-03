package com.echothedeveloper.utils;

import java.util.Arrays;

public class CompareMethods {
    public static boolean strInArray(String[] array, String value) {
        if (array == null || value == null) {
            return false; // Handle null inputs safely
        }
        return Arrays.stream(array).anyMatch(value::equals);
    }
}
