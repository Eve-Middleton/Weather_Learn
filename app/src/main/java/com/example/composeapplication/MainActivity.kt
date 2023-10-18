package com.example.composeapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.model.Now
import com.example.composeapplication.model.WeatherState
import com.example.composeapplication.screen.ComposeText
import com.example.composeapplication.screen.LocationScreen
import com.example.composeapplication.screen.NowScreen
import com.example.composeapplication.screen.WeatherDaysScreen
import com.example.composeapplication.ui.theme.*
import com.example.composeapplication.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    setWeather(weatherViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun setWeather(weatherViewModel: WeatherViewModel) {
    when (val result = weatherViewModel.weatherData.value) {
        //数据获取成功
        is WeatherState.Success -> {
            Log.d("--result--", result.weather.toString())
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()//充满屏幕
                    .background(
                        //渐变色
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Purple500,
                                Teal200
                            )

                        )
                    )
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                LocationScreen(result.weather.result.location)
                Spacer(modifier = Modifier.height(100.dp))
                NowScreen(result.weather.result.now)
                Spacer(modifier = Modifier.height(20.dp))
                WeatherDaysScreen(result.weather.result.forecasts)
            }
        }
        //数据获取失败
        is WeatherState.Failure -> {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                ComposeText(text = "${result.error}", color = Color.Red, fontSize = 18.sp)
            }
        }
        //数据加载中
        is WeatherState.Loading -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Purple500,
                                Teal200
                            )
                        )
                    )

            ) {
                Surface(
                    onClick = { Unit },
                    color = Color.Transparent,
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(18.dp),
                            strokeWidth = 2.dp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        ComposeText(text = "加载天气中", color = Color.White, fontSize = 16.sp)
                    }

                }
            }
        }

        else -> {}
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApplicationTheme {
        Greeting("Android")
    }
}