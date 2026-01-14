package com.weather.service.controller;

import com.weather.service.dto.WeatherResponseDTO;
import com.weather.service.service.WeatherService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@Validated
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<WeatherResponseDTO> getWeatherByCity(
            @RequestParam @NotBlank(message = "City name is required") String city) {

        WeatherResponseDTO weatherData = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(weatherData);
    }
}