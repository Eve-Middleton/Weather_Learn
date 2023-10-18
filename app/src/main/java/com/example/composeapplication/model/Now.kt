package com.example.composeapplication.model

data class Now(
    val feels_like: Int,
    val rh: Int,
    val temp: Int,
    val text: String,
    val uptime: String,
    val wind_class: String,
    val wind_dir: String
)