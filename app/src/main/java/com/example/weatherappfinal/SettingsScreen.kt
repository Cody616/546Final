package com.example.weatherappfinal

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SettingsScreen(settingsViewModel: SettingsViewModel = viewModel()) {
    val lightThreshold by settingsViewModel.lightClothingThreshold.collectAsState(initial = 20)
    val mediumThreshold by settingsViewModel.mediumClothingThreshold.collectAsState(initial = 15)
    val heavyThreshold by settingsViewModel.heavyClothingThreshold.collectAsState(initial = 5)
    val useFahrenheit by settingsViewModel.useFahrenheit.collectAsState(initial = false)

    val temperatureUnit = if (useFahrenheit) "°F" else "°C"
    val lightRange = if (useFahrenheit) 50f..90f else 10f..30f
    val mediumRange = if (useFahrenheit) 30f..70f else 0f..20f
    val heavyRange = if (useFahrenheit) -10f..50f else -10f..10f

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Set Clothing Preferences", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Light Clothing Threshold: $lightThreshold$temperatureUnit")
        Slider(
            value = lightThreshold.toFloat(),
            onValueChange = { settingsViewModel.setLightClothingThreshold(it.toInt()) },
            valueRange = lightRange,
            steps = (lightRange.endInclusive - lightRange.start).toInt()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Medium Clothing Threshold: $mediumThreshold$temperatureUnit")
        Slider(
            value = mediumThreshold.toFloat(),
            onValueChange = { settingsViewModel.setMediumClothingThreshold(it.toInt()) },
            valueRange = mediumRange,
            steps = (mediumRange.endInclusive - mediumRange.start).toInt()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Heavy Clothing Threshold: $heavyThreshold$temperatureUnit")
        Slider(
            value = heavyThreshold.toFloat(),
            onValueChange = { settingsViewModel.setHeavyClothingThreshold(it.toInt()) },
            valueRange = heavyRange,
            steps = (heavyRange.endInclusive - heavyRange.start).toInt()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Temperature Unit: ${if (useFahrenheit) "Fahrenheit" else "Celsius"}")
        Switch(
            checked = useFahrenheit,
            onCheckedChange = { settingsViewModel.setUseFahrenheit(it) }
        )
    }
}
