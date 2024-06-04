package com.example.appdatcomtam.Screen.ScreenAdim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appdatcomtam.AppNavHost
import com.example.appdatcomtam.R
import com.example.appdatcomtam.Screen.MyBottomAppBar

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
                        "Cum Tứm Dim ",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_splash),
                        contentDescription = "kkk",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(10.dp)
                    )
                },

                )
        },
    ) {
        it
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