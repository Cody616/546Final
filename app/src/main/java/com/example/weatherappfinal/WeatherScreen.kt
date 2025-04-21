package com.example.weatherappfinal

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(
    weatherViewModel: WeatherViewModel = viewModel(),
    settingsViewModel: SettingsViewModel = viewModel()
) {
    var cityName by remember { mutableStateOf("") }
    val weatherState by weatherViewModel.weatherState.collectAsState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val useFahrenheit by settingsViewModel.useFahrenheit.collectAsState(initial = false)

    fun convertTemperature(tempC: Double, useFahrenheit: Boolean): String {
        return if (useFahrenheit) {
            val tempF = (tempC * 9 / 5) + 32
            String.format("%.1f°F", tempF)
        } else {
            String.format("%.1f°C", tempC)
        }
    }


    // Retrieve user-defined temperature thresholds
    val lightThreshold by settingsViewModel.lightClothingThreshold.collectAsState(initial = 20)
    val mediumThreshold by settingsViewModel.mediumClothingThreshold.collectAsState(initial = 15)
    val heavyThreshold by settingsViewModel.heavyClothingThreshold.collectAsState(initial = 5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Enter City Name", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = cityName,
            onValueChange = { cityName = it },
            label = { Text("City") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (cityName.isNotBlank()) {
                    coroutineScope.launch {
                        weatherViewModel.fetchWeather(cityName)
                    }
                } else {
                    Toast.makeText(context, "Please enter a city name", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get Weather")
        }

        Spacer(modifier = Modifier.height(16.dp))

        weatherState?.let { weather ->
            Text("City: ${weather.name}")
            Text("Temperature: ${convertTemperature(weather.main.temp, useFahrenheit)}")
            Text("Humidity: ${weather.main.humidity}%")
            Text("Wind Speed: ${weather.wind.speed} m/s")
            Text("Description: ${weather.weather.firstOrNull()?.description ?: "N/A"}")

            Spacer(modifier = Modifier.height(16.dp))

            // Determine clothing suggestion based on temperature thresholds
            val temperature = weather.main.temp
            val clothingSuggestion = when {
                temperature >= lightThreshold -> "Light Clothing"
                temperature >= mediumThreshold -> "Medium Clothing"
                else -> "Heavy Clothing"
            }

            Text("Suggested Clothing: $clothingSuggestion")
        }
    }
}
