package com.weather.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiResponseDTO {
    private Location location;
    private Current current;
    private Error error;

    // Getters and Setters
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public Current getCurrent() { return current; }
    public void setCurrent(Current current) { this.current = current; }

    public Error getError() { return error; }
    public void setError(Error error) { this.error = error; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        private String name;
        private String region;
        private String country;
        private Double lat;
        private Double lon;

        @JsonProperty("tz_id")
        private String tzId;

        @JsonProperty("localtime_epoch")
        private Long localtimeEpoch;

        private String localtime;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getRegion() { return region; }
        public void setRegion(String region) { this.region = region; }

        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }

        public Double getLat() { return lat; }
        public void setLat(Double lat) { this.lat = lat; }

        public Double getLon() { return lon; }
        public void setLon(Double lon) { this.lon = lon; }

        public String getTzId() { return tzId; }
        public void setTzId(String tzId) { this.tzId = tzId; }

        public Long getLocaltimeEpoch() { return localtimeEpoch; }
        public void setLocaltimeEpoch(Long localtimeEpoch) { this.localtimeEpoch = localtimeEpoch; }

        public String getLocaltime() { return localtime; }
        public void setLocaltime(String localtime) { this.localtime = localtime; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {
        @JsonProperty("last_updated_epoch")
        private Long lastUpdatedEpoch;

        @JsonProperty("last_updated")
        private String lastUpdated;

        @JsonProperty("temp_c")
        private Double tempC;

        @JsonProperty("temp_f")
        private Double tempF;

        @JsonProperty("wind_kph")
        private Double windKph;

        private Integer humidity;

        @JsonProperty("condition")
        private Condition condition;

        // Getters and Setters
        public Long getLastUpdatedEpoch() { return lastUpdatedEpoch; }
        public void setLastUpdatedEpoch(Long lastUpdatedEpoch) { this.lastUpdatedEpoch = lastUpdatedEpoch; }

        public String getLastUpdated() { return lastUpdated; }
        public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }

        public Double getTempC() { return tempC; }
        public void setTempC(Double tempC) { this.tempC = tempC; }

        public Double getTempF() { return tempF; }
        public void setTempF(Double tempF) { this.tempF = tempF; }

        public Double getWindKph() { return windKph; }
        public void setWindKph(Double windKph) { this.windKph = windKph; }

        public Integer getHumidity() { return humidity; }
        public void setHumidity(Integer humidity) { this.humidity = humidity; }

        public Condition getCondition() { return condition; }
        public void setCondition(Condition condition) { this.condition = condition; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Condition {
        private String text;
        private String icon;
        private Integer code;

        // Getters and Setters
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }

        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }

        public Integer getCode() { return code; }
        public void setCode(Integer code) { this.code = code; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        private Integer code;
        private String message;

        // Getters and Setters
        public Integer getCode() { return code; }
        public void setCode(Integer code) { this.code = code; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }
}