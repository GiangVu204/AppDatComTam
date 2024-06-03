package com.example.appdatcomtam.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.sharp.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appdatcomtam.Greeting
import com.example.appdatcomtam.ROUTE_NAME
import com.example.appdatcomtam.Screen.ScreenAdim.HomeAdminScreen



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController? = null) {
    val navigationController = rememberNavController()
    val selected = remember { mutableStateOf("home") }
    val currentDestination by navigationController.currentBackStackEntryAsState()
    var title = currentDestination?.destination?.route ?: "Thanh Toan"
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                ),
                title = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column {
                            if (selected.value == "home") {
                                title = ""
                                Text("Make Your", color = Color.Gray, fontSize = 10.sp, modifier = Modifier.padding(start = 10.dp))
                                Text("Beautiful", color = Color.Black,fontSize = 21.sp)
                            }else{
                                Text(title)
                            }
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle search click */ }) {
                        Icon(imageVector = Icons.Sharp.Search, contentDescription = "Search", tint = Color.Black)
                    }
                },
                actions = {
                    IconButton(onClick ={       }) {
                        Icon(imageVector = Icons.Sharp.ShoppingCart, contentDescription = "Cart", tint = Color.Black)
                    }
                }
            )
        },
        bottomBar = {
            MyBottomAppBar(navigationController, selected)
        },
    ) { innerPadding ->
        NavHost(
            navController = navigationController,
            startDestination = ROUTE_NAME.homeAdmin.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ROUTE_NAME.homeAdmin.name) { HomeAdminScreen(navController = navController) }
            composable(ROUTE_NAME.showbill.name) { Greeting(name = "ShowBill Page") }
            composable(ROUTE_NAME.manager.name) { Greeting(name = "Manager Page") }
            composable(ROUTE_NAME.user.name) { Greeting(name = "User Page") }
        }
    }
}

@Composable
fun MyBottomAppBar(navigationController: NavHostController, selected: MutableState<String>) {
    BottomAppBar(containerColor = Color.White) {
        IconButton(
            onClick = {
                selected.value = "home"
                navigationController.navigate(ROUTE_NAME.homeAdmin.name) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = if (selected.value == "home") Icons.Filled.Home else Icons.Outlined.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(26.dp),
                    tint = Color.Black
                )
            }
        }
        IconButton(
            onClick = {
                selected.value = "favorite"
                navigationController.navigate(ROUTE_NAME.showbill.name) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = if (selected.value == "favorite") Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(26.dp),
                    tint = Color.Black
                )
            }
        }
        IconButton(
            onClick = {
                selected.value = "notifications"
                navigationController.navigate(ROUTE_NAME.manager.name) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = if (selected.value == "notifications") Icons.Filled.Notifications else Icons.Outlined.Notifications,
                    contentDescription = "Notifications",
                    modifier = Modifier.size(26.dp),
                    tint = Color.Black
                )
            }
        }
        IconButton(
            onClick = {
                selected.value = "profile"
                navigationController.navigate(ROUTE_NAME.user.name) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = if (selected.value == "profile") Icons.Filled.AccountCircle else Icons.Outlined.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier.size(26.dp),
                    tint = Color.Black
                )
            }
        }
    }
}