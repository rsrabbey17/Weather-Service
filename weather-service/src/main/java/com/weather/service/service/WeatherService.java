package com.weather.service.service;

import com.weather.service.dto.WeatherResponseDTO;

public interface WeatherService {
    WeatherResponseDTO getWeatherByCity(String city);
}