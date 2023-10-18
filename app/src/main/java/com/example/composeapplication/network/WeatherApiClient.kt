package com.example.composeapplication.network

import com.example.composeapplication.model.WeatherModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

object WeatherApiClient {
    private val BASE_URL = "https://api.map.baidu.com/"
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val weatherApiService:WeatherApiService by lazy{
        retrofit.create(WeatherApiService::class.java)
    }
}

interface WeatherApiService {
    @GET("/weather/v1/")
    suspend fun getWeatherData(
        @Query("district_id") district_id: String,
        @Query("data_type") data_type: String,
        @Query("ak") ak: String,
        ): WeatherModel
}