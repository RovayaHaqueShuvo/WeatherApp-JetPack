package com.own_world.weatherapp_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.own_world.weatherapp_jetpack.Screens.HomeScreen.WeatherHomeViewModel
import com.own_world.weatherapp_jetpack.Screens.HomeScreen.WeatherUiState
import com.own_world.weatherapp_jetpack.ui.theme.WeatherAppJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,) {

    val vm: WeatherHomeViewModel = viewModel()

    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        when (vm.uiState) {
            is WeatherUiState.Loading -> Text(text = "Loading Data")
            is WeatherUiState.Error -> Text(text = "Failed to load data")
            is WeatherUiState.Success -> Text(text = "Data Success")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppJetpackTheme {
        Greeting("Android")
    }
}