package com.example.appdatcomtam.Screen.ScreenAdim

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appdatcomtam.R
import com.example.appdatcomtam.ROUTE_NAME

@Composable
fun ManagerCategoriesScreen(navController: NavController? = null) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.Black)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 6.dp)
            .background(Color(0xFF252121))
    ) {
        // Quản lý món ăn
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 8.dp)
                .clickable { navController?.navigate("${ROUTE_NAME.addloaisp.name}") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_splash),
                contentDescription = "Food Manager",
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.CenterStart)
            )
            Text(
                text = "Thêm loại món ăn",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 80.dp, top = 10.dp),
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .clickable { navController?.navigate("${ROUTE_NAME.updateloaisp.name}") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_splash),
                contentDescription = "Food Type Manager",
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.CenterStart)
            )
            Text(
                text = "Sửa loại món ăn",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 80.dp, top = 10.dp) ,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .clickable { navController?.navigate("${ROUTE_NAME.deleteloaisp.name}") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_splash),
                contentDescription = "Food Type Manager",
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.CenterStart)
            )
            Text(
                text = "Xóa loại món ăn",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 80.dp, top = 10.dp) ,
                color = Color.White
            )
        }
    }
}