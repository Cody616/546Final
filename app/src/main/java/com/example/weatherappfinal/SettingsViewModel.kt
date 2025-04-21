package com.example.weatherappfinal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.booleanPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val dataStore = application.dataStore

    val lightClothingThreshold: Flow<Int> = dataStore.data
        .map { preferences -> preferences[PreferenceKeys.LIGHT_CLOTHING_THRESHOLD] ?: 20 }

    val mediumClothingThreshold: Flow<Int> = dataStore.data
        .map { preferences -> preferences[PreferenceKeys.MEDIUM_CLOTHING_THRESHOLD] ?: 15 }

    val heavyClothingThreshold: Flow<Int> = dataStore.data
        .map { preferences -> preferences[PreferenceKeys.HEAVY_CLOTHING_THRESHOLD] ?: 5 }

    val useFahrenheit: Flow<Boolean> = dataStore.data
        .map { preferences -> preferences[PreferenceKeys.USE_FAHRENHEIT] ?: false }

    fun setLightClothingThreshold(value: Int) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[PreferenceKeys.LIGHT_CLOTHING_THRESHOLD] = value
            }
        }
    }

    fun setMediumClothingThreshold(value: Int) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[PreferenceKeys.MEDIUM_CLOTHING_THRESHOLD] = value
            }
        }
    }

    fun setHeavyClothingThreshold(value: Int) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[PreferenceKeys.HEAVY_CLOTHING_THRESHOLD] = value
            }
        }
    }


    fun setUseFahrenheit(value: Boolean) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[PreferenceKeys.USE_FAHRENHEIT] = value
            }
        }
    }
}