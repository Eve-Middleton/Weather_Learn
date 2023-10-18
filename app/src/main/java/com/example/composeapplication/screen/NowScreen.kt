package com.example.composeapplication.screen

import android.graphics.ColorSpace
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.R
import com.example.composeapplication.model.Now
import com.example.composeapplication.ui.theme.Purple200

@Composable
fun NowScreen(now:Now) {
    if (now.text == "晴天"){
        Image(
            painter = painterResource(id = R.drawable.ic_sun),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
    }else if(now.text  == "多云"){
        Image(
            painter = painterResource(id = R.drawable.ic_cloudy_day),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
    }else{
        Image(
            painter = painterResource(id = R.drawable.ic_heavy_rain),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
    }
    ComposeText("${now.text}°", fontSize = 48.sp)
    Surface(
        modifier = Modifier.fillMaxWidth(0.5f),
        color = Color(244, 250, 255),
        shape = RoundedCornerShape(48)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,//子元素兼具相等
            verticalAlignment = Alignment.CenterVertically,//居中
            modifier = Modifier.fillMaxWidth().padding(8.dp)//外边距
        ) {
            ComposeText(text = "${now.wind_dir}", color = Color.Black, fontSize = 12.sp)
            ComposeText(text = "${now.wind_class}", color = Color.Black, fontSize = 12.sp)
            ComposeText(text = "湿度", color = Color.Black, fontSize = 12.sp)
            ComposeText(text = "${now.rh}%", color = Color.Black, fontSize = 12.sp)
        }
    }
}