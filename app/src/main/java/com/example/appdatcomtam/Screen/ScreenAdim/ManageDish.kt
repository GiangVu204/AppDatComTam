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
    val navigationController = rememberNavController()
    val selected = remember { mutableStateOf("home") }
    val currentDestination by navigationController.currentBackStackEntryAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color("#312F2E".toColorInt()),
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        "Cum tứm đim ",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_splash),
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(10.dp)
                    )
                },

            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color.Black)
            )
            ManageDish(navController)
        }
    )
}


@Composable
fun ManageDish(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 95.dp)
            .background(color = Color("#252121".toColorInt()))
    ) {
        // Quản lý món ăn
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
//                .clickable { navController?.navigate("${ROUTE_NAME.managerDish.name}") }
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
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White
                ),
                modifier = Modifier
                    .padding(start = 80.dp, top = 10.dp)

            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Quản lý loại món ăn
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
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
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White
                ),
                modifier = Modifier.padding(start = 80.dp, top = 10.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Quản lý loại món ăn
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
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
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White
                ),
                modifier = Modifier.padding(start = 80.dp, top = 10.dp)
            )
        }
    }
}


//@Composable
//fun TopBar () {
//    Box(
//        modifier = Modifier
//    ) {
//        Column (
//            modifier = Modifier
//
//        ) {
//            ImageTopBar(Image = R.drawable.logo_splash)
//
//        }
//    }
//}
//
//
//@Composable
//fun ImageTopBar(Image: Int) {
//    Image(
//        painter = painterResource(id = Image),
//        contentDescription = null,
//        modifier = Modifier
//    )
//}