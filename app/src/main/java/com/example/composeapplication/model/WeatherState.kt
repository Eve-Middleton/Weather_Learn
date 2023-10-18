package com.example.composeapplication.model

public sealed class WeatherState {
    class Success(val weather: WeatherModel) : WeatherState()
    class Failure(val error: Throwable) : WeatherState()
    class Loading : WeatherState()
    class Empty : WeatherState()
}