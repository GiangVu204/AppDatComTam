package com.example.appdatcomtam

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Preview
@Composable
fun LoginScreen(navController: NavController? = null) {

    Text(
        text = "Chào mừng đến với đăng nhập",

    )
    Text(text = "Tạm biệt bạn")
    Text(text = "Goodbye")

}
