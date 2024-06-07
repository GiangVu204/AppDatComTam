package com.example.appdatcomtam.Screen.ScreenAdim

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ShowBillScreen(navController: NavController? = null) {
    LazyColumn (
        Modifier
            .fillMaxSize()
            .background(Color(0xFF252120))
            .padding(5.dp)
    ){
        item{
            Bill()
        }
    }
}

@Composable
fun Bill(){
    Row (
        Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Column {
            Text(
                text = "Đơn hàng đã chấp nhận",
                color = Color.Red,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "10/3/2023 9:20",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
        Spacer(Modifier.width(30.dp))
        Column {
            Text(
                text = "3 món",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "98K",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
    }
    Spacer(Modifier.height(15.dp))
    Row (
        Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Column {
            Text(
                text = "Đơn hàng đã huỷ",
                color = Color.Red,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "10/3/2023 9:20",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
        Spacer(Modifier.width(30.dp))
        Column {
            Text(
                text = "3 món",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "98K",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
    }
    Spacer(Modifier.height(15.dp))
    Row (
        Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Column {
            Text(
                text = "Đơn hàng đã huỷ",
                color = Color.Red,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "10/3/2023 9:20",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
        Spacer(Modifier.width(30.dp))
        Column {
            Text(
                text = "3 món",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "98K",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
    }
    Spacer(Modifier.height(15.dp))
    Row (
        Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Column {
            Text(
                text = "Đơn hàng đã được giao",
                color = Color.Red,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "10/3/2023 9:20",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
        Spacer(Modifier.width(30.dp))
        Column {
            Text(
                text = "3 món",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "98K",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
    }
    Spacer(Modifier.height(15.dp))
    Row (
        Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Column {
            Text(
                text = "Đơn hàng đã được giao",
                color = Color.Red,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "10/3/2023 9:20",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
        Spacer(Modifier.width(30.dp))
        Column {
            Text(
                text = "3 món",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "98K",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
    }
    Spacer(Modifier.height(15.dp))
    Row (
        Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Column {
            Text(
                text = "Đơn hàng đã được giao",
                color = Color.Red,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "10/3/2023 9:20",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
        Spacer(Modifier.width(30.dp))
        Column {
            Text(
                text = "3 món",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "98K",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
    }
    Spacer(Modifier.height(15.dp))
    Row (
        Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Column {
            Text(
                text = "Đơn hàng đã được giao",
                color = Color.Red,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "10/3/2023 9:20",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
        Spacer(Modifier.width(30.dp))
        Column {
            Text(
                text = "3 món",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "98K",
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShowBill(){
    ShowBillScreen()
}