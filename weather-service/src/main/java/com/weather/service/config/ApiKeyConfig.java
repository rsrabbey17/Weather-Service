package com.weather.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather.api")
public class ApiKeyConfig {
    private String key;
    private String baseUrl = "http://api.weatherapi.com/v1";

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApiKey() {
        return key;
    }

    public String getCurrentWeatherUrl() {
        return baseUrl + "/current.json";
    }
}