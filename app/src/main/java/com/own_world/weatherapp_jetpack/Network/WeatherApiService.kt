package com.own_world.weatherapp_jetpack.Network

import com.own_world.weatherapp_jetpack.Utils.WEATHER_API_KEY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface WeatherApiService{
    @GET("weather?lat=23.7911&lon=90.3666&appid=$WEATHER_API_KEY")
    suspend fun getCurrentWeather():CurrentWeather

    @GET("forecast?lat=23.7911&lon=90.3666&appid=$WEATHER_API_KEY")
    suspend fun getForecastWeather():ForecastWeather
}

object WeatherApi{
    val retrofitService:WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)

    }

}