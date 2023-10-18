package com.example.composeapplication.model

data class Forecast(
    val date: String,
    val high: Int,
    val low: Int,
    val text_day: String,
    val text_night: String,
    val wc_day: String,
    val wc_night: String,
    val wd_day: String,
    val wd_night: String,
    val week: String
)