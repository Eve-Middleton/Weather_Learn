package com.example.composeapplication.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composeapplication.model.Location

@Composable
fun LocationScreen(location: Location){
    ComposeText(
        text = location.province + "-"+location.city+ "-"+location.name,
        fontWeight = FontWeight.Bold
    )
}