
package com.example.weatherappfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherappfinal.ui.theme.WeatherAppFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppFinalTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    WeatherAppNav()
                }
            }
        }
    }
}

@Composable
fun WeatherAppNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) { WelcomeScreen(navController) }
        composable(Screen.MainMenu.route) { MainMenuScreen(navController) }
        composable(Screen.Weather.route) { WeatherScreen() }
        composable(Screen.Settings.route) { SettingsScreen() }
    }
}
