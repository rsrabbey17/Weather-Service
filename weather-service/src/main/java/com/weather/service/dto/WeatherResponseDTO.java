package com.weather.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherResponseDTO {
    private String city;
    private String country;

    @JsonProperty("latitude")
    private Double lat;

    @JsonProperty("longitude")
    private Double lon;

    @JsonProperty("temperature_celsius")
    private Double temperatureCelsius;

    @JsonProperty("wind_kmh")
    private Double windKmh;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("condition")
    private String condition;

    @JsonProperty("last_updated")
    private String lastUpdated;

    // Constructors
    public WeatherResponseDTO() {
    }

    public WeatherResponseDTO(String city, String country, Double lat, Double lon,
                              Double temperatureCelsius, Double windKmh, Integer humidity,
                              String condition, String lastUpdated) {
        this.city = city;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.temperatureCelsius = temperatureCelsius;
        this.windKmh = windKmh;
        this.humidity = humidity;
        this.condition = condition;
        this.lastUpdated = lastUpdated;
    }

    // Getters and Setters
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLon() { return lon; }
    public void setLon(Double lon) { this.lon = lon; }

    public Double getTemperatureCelsius() { return temperatureCelsius; }
    public void setTemperatureCelsius(Double temperatureCelsius) { this.temperatureCelsius = temperatureCelsius; }

    public Double getWindKmh() { return windKmh; }
    public void setWindKmh(Double windKmh) { this.windKmh = windKmh; }

    public Integer getHumidity() { return humidity; }
    public void setHumidity(Integer humidity) { this.humidity = humidity; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }
}