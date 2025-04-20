package com.example.weatherappfinal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherState = MutableStateFlow<WeatherResponse?>(null)
    val weatherState: StateFlow<WeatherResponse?> = _weatherState

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {
                val response = WeatherApiService.api.getWeatherByCity(city, "5274617a41d1c902d1f2e18470e41742")

                _weatherState.value = response
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
