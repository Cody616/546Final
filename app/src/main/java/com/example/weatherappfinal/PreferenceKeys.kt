package com.example.weatherappfinal

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.booleanPreferencesKey

object PreferenceKeys {
    val LIGHT_CLOTHING_THRESHOLD = intPreferencesKey("light_clothing_threshold")
    val MEDIUM_CLOTHING_THRESHOLD = intPreferencesKey("medium_clothing_threshold")
    val HEAVY_CLOTHING_THRESHOLD = intPreferencesKey("heavy_clothing_threshold")
    val USE_FAHRENHEIT = booleanPreferencesKey("use_fahrenheit")
}
