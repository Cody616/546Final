plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

android {
    namespace = "com.example.weatherappfinal"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.weatherappfinal"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "2.0.0"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    dependencies {
        dependencies {
            // Jetpack Compose libraries
            implementation("androidx.compose.ui:ui:1.3.0")
            implementation("androidx.compose.material3:material3:1.0.0")
            implementation("androidx.activity:activity-compose:1.6.0")
            implementation("androidx.compose.ui:ui-tooling-preview:1.3.0")
            debugImplementation("androidx.compose.ui:ui-tooling:1.3.0")

            // Navigation for Compose
            implementation("androidx.navigation:navigation-compose:2.7.7")

            // Retrofit for network requests
            implementation("com.squareup.retrofit2:retrofit:2.9.0")
            implementation("com.squareup.retrofit2:converter-gson:2.9.0")

            // Kotlin Coroutines for asynchronous operations
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

            // OkHttp for logging network requests
            implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

            // Lifecycle ViewModel Compose
            implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")

            implementation("androidx.compose.ui:ui:1.3.0")
            implementation("androidx.compose.material3:material3:1.0.0")
            implementation("androidx.activity:activity-compose:1.6.0")
            implementation("androidx.compose.ui:ui-tooling-preview:1.3.0")
            debugImplementation("androidx.compose.ui:ui-tooling:1.3.0")
            implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
            implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")

            implementation("androidx.compose.ui:ui:1.3.0")
            implementation("androidx.compose.material3:material3:1.0.0")
            implementation("androidx.activity:activity-compose:1.6.0")
            implementation("androidx.compose.ui:ui-tooling-preview:1.3.0")
            debugImplementation("androidx.compose.ui:ui-tooling:1.3.0")
            implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
            implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
            implementation("com.squareup.retrofit2:retrofit:2.9.0")
            implementation("com.squareup.retrofit2:converter-gson:2.9.0")
            implementation("com.google.android.gms:play-services-location:18.0.0")
            implementation("androidx.compose.runtime:runtime-livedata:1.6.0")
            implementation("androidx.datastore:datastore-preferences:1.1.4")

        }

    }

}
