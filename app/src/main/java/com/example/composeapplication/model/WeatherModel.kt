package com.example.composeapplication.model

data class WeatherModel(
    val message: String,
    val result: Result,
    val status: Int
)