package com.example.composeapplication.model

data class Result(
    val forecasts: List<Forecast>,
    val location: Location,
    val now: Now
)