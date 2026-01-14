package com.weather.service.service.impl;

import com.weather.service.config.ApiKeyConfig;
import com.weather.service.dto.WeatherApiResponseDTO;
import com.weather.service.dto.WeatherResponseDTO;
import com.weather.service.exception.WeatherServiceException;
import com.weather.service.service.WeatherService;
import com.weather.service.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

    private final RestTemplate restTemplate;
    private final ApiKeyConfig apiKeyConfig;

    public WeatherServiceImpl(RestTemplate restTemplate, ApiKeyConfig apiKeyConfig) {
        this.restTemplate = restTemplate;
        this.apiKeyConfig = apiKeyConfig;
    }

    @Override
    public WeatherResponseDTO getWeatherByCity(String city) {
        // Validate city name
        ValidationUtil.validateCityName(city);

        try {
            // Build URL with query parameters
            String url = UriComponentsBuilder.fromHttpUrl(apiKeyConfig.getCurrentWeatherUrl())
                    .queryParam("key", apiKeyConfig.getApiKey())
                    .queryParam("q", city)
                    .queryParam("aqi", "no")
                    .toUriString();

            log.info("Calling WeatherAPI for city: {}", city);

            // Make API call
            ResponseEntity<WeatherApiResponseDTO> response = restTemplate.getForEntity(
                    url, WeatherApiResponseDTO.class);

            WeatherApiResponseDTO apiResponse = response.getBody();

            if (apiResponse == null) {
                throw new WeatherServiceException("No response received from Weather API");
            }

            // Check for API error
            if (apiResponse.getError() != null) {
                throw new WeatherServiceException(
                        "Weather API Error: " + apiResponse.getError().getMessage());
            }

            // Convert to response DTO
            return mapToWeatherResponseDTO(apiResponse);

        } catch (HttpClientErrorException e) {
            log.error("HTTP error while calling WeatherAPI: {}", e.getMessage());
            throw new WeatherServiceException("Failed to fetch weather data: " + e.getStatusText());
        } catch (Exception e) {
            log.error("Error fetching weather data: {}", e.getMessage());
            throw new WeatherServiceException("Failed to fetch weather data: " + e.getMessage());
        }
    }

    private WeatherResponseDTO mapToWeatherResponseDTO(WeatherApiResponseDTO apiResponse) {
        WeatherResponseDTO response = new WeatherResponseDTO();

        if (apiResponse.getLocation() != null) {
            response.setCity(apiResponse.getLocation().getName());
            response.setCountry(apiResponse.getLocation().getCountry());
            response.setLat(apiResponse.getLocation().getLat());
            response.setLon(apiResponse.getLocation().getLon());
        }

        if (apiResponse.getCurrent() != null) {
            response.setTemperatureCelsius(apiResponse.getCurrent().getTempC());
            response.setWindKmh(apiResponse.getCurrent().getWindKph());
            response.setHumidity(apiResponse.getCurrent().getHumidity());
            response.setLastUpdated(apiResponse.getCurrent().getLastUpdated());

            if (apiResponse.getCurrent().getCondition() != null) {
                response.setCondition(apiResponse.getCurrent().getCondition().getText());
            }
        }

        return response;
    }
}