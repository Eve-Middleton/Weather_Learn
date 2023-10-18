package com.example.composeapplication.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapplication.model.WeatherState
import com.example.composeapplication.repository.WeatherRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    var weatherData: MutableState<WeatherState> = mutableStateOf(WeatherState.Empty())

    init {
        getWeatherData("110100", "all", "YOUR_BAIDU_MAP_API_KEY")
    }

    private fun getWeatherData(district_id: String, data_type: String, ak: String) {
        viewModelScope.launch {
            WeatherRepository.getWeather(district_id, data_type, ak)
                .onStart {
                    weatherData.value = WeatherState.Loading()
                }
                .catch { e ->
                    weatherData.value = WeatherState.Failure(e)
                }
                .collect { response ->
                    weatherData.value = WeatherState.Success(response)
                }
        }
    }

}