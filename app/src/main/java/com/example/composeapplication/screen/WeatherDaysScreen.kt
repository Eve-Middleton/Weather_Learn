package com.example.composeapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.R
import com.example.composeapplication.model.Forecast

@Composable
fun WeatherDaysScreen(forecasts: List<Forecast>) {

    val itemData = listOf<String>("周一", "周二", "周三", "周四", "周五", "周六", "周日")
    LazyRow {
        items(forecasts) { forecast ->
            WeatherItems(forecast)
        }
    }
}


@Composable
fun WeatherItems(forecast: Forecast) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 8.dp, end = 10.dp),

        ) {
        ComposeText(forecast.week)
        if (forecast.text_day == "晴天") {
            Image(
                painter = painterResource(id = R.drawable.ic_sun),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
        } else if (forecast.text_day == "多云") {
            Image(
                painter = painterResource(id = R.drawable.ic_cloudy_day),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.ic_heavy_rain),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
        }
        Row {
            ComposeText(forecast.text_day, fontSize = 10.sp)
            Spacer(modifier = Modifier.width(5.dp))
            ComposeText(forecast.text_night, fontSize = 10.sp)
        }
        ComposeText("${forecast.high}°/${forecast.low}°", fontSize = 22.sp)
    }
}