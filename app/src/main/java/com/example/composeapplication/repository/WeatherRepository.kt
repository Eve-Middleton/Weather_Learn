package com.example.composeapplication.repository

import com.example.composeapplication.model.WeatherModel
import com.example.composeapplication.network.WeatherApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.Dispatchers

class WeatherRepository {
    companion object {
        fun getWeather(district_id: String, data_type: String, ak: String): Flow<WeatherModel> =
            flow {
                var weather = WeatherApiClient.weatherApiService.getWeatherData(
                    district_id,
                    data_type,
                    ak
                )
                emit(weather)

            }.flowOn(Dispatchers.IO)
    }
}