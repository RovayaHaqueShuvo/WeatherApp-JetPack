package com.own_world.weatherapp_jetpack.Screens.HomeScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.own_world.weatherapp_jetpack.Network.CurrentWeather
import com.own_world.weatherapp_jetpack.Network.ForecastWeather
import com.own_world.weatherapp_jetpack.Network.WeatherApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class WeatherHomeViewModel:ViewModel() {

    var uiState: WeatherUiState by mutableStateOf(WeatherUiState.Loading)

    init {
     getWeatherData()
    }
    fun getWeatherData(){
        viewModelScope.launch {
          uiState = try {
              val current = async { getCurrentData() }.await()
              val forecast = async { getForecastData() }.await()
              val weather = Weather(current,forecast)
              WeatherUiState.Success(weather)

          }catch(e:Exception){
              WeatherUiState.Error
          }

        }
    }
}

private suspend fun getCurrentData():CurrentWeather{
    return WeatherApi.retrofitService.getCurrentWeather()
}
private suspend fun getForecastData():ForecastWeather{
    return WeatherApi.retrofitService.getForecastWeather()
}

sealed interface WeatherUiState{
    data class Success(val weather: Weather):WeatherUiState
    data object Error:WeatherUiState
    data object Loading : WeatherUiState

}

data class Weather (
        val currentWeather: CurrentWeather,
        val forecastWeather: ForecastWeather
        )