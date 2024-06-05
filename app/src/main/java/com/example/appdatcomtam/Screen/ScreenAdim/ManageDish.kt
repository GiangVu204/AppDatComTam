package com.example.appdatcomtam.Screen.ScreenAdim

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appdatcomtam.AppNavHost
import com.example.appdatcomtam.R
import com.example.appdatcomtam.ROUTE_NAME
import com.example.appdatcomtam.Screen.MyBottomAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageDishScreen(navController: NavController? = null) {
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
                .clickable { navController?.navigate("${ROUTE_NAME.addmonan.name}") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_splash),
                contentDescription = "Food Manager",
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.CenterStart)
            )
            Text(
                text = "Thêm món ăn",
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
                .clickable { navController?.navigate("${ROUTE_NAME.updatemonam.name}") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_splash),
                contentDescription = "Food Type Manager",
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.CenterStart)
            )
            Text(
                text = "Sửa món ăn",
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
                .clickable { navController?.navigate("${ROUTE_NAME.deletemonan.name}") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_splash),
                contentDescription = "Food Type Manager",
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.CenterStart)
            )
            Text(
                text = "Xóa món ăn",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 80.dp, top = 10.dp) ,
                color = Color.White
            )
        }
    }
}

