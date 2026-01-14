package com.weather.service.util;

public class ValidationUtil {

    private ValidationUtil() {
        // Utility class
    }

    public static void validateCityName(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City name cannot be empty");
        }

        if (!city.matches("^[a-zA-Z\\s\\-',.]+$")) {
            throw new IllegalArgumentException("Invalid city name format");
        }

        if (city.length() > 100) {
            throw new IllegalArgumentException("City name is too long");
        }
    }
}