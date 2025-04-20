package com.example.weatherappfinal

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object MainMenu : Screen("main_menu")
    object Weather : Screen("weather")
    object Settings : Screen("settings")
}