package com.example.composeapplication.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ComposeText(text:String,color: Color=Color.White,fontSize:TextUnit=20.sp,fontWeight: FontWeight=FontWeight.Normal) {
    Text(text = text,
        color = color,
        fontSize =fontSize ,
        fontWeight = fontWeight
    )
}