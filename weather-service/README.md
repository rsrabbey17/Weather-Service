# Weather Information Service

A Spring Boot-based REST API service that provides current weather information for cities worldwide using WeatherAPI.com.

## Features

- Get current weather information by city name
- Returns structured JSON response with essential weather data
- Secure API key storage using environment variables
- Input validation and error handling
- Single endpoint design as per requirements

## Prerequisites

- Java 21 or higher
- Gradle 8.x
- [WeatherAPI.com](https://www.weatherapi.com/) account and API key (free tier available)

## Getting Started

### 1. Get Your API Key

1. Create a free account at [WeatherAPI.com](https://www.weatherapi.com/)
2. Verify your email address
3. Get your API key from the dashboard
4. Free tier includes: 1 million calls/month, 3 calls/second

### 2. Set Up the Project

```bash
# Clone the repository or extract the project
cd weather-service

# Set your API key as environment variable
# Windows (Command Prompt):
set WEATHER_API_KEY=your_api_key_here

# Windows (PowerShell):
$env:WEATHER_API_KEY="your_api_key_here"

# Linux/Mac:
export WEATHER_API_KEY=your_api_key_here