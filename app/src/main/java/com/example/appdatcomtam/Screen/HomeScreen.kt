package com.example.appdatcomtam.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appdatcomtam.Greeting
import com.example.appdatcomtam.R
import com.example.appdatcomtam.ROUTE_NAME
import com.example.appdatcomtam.Screen.ScreenAdim.HomeAdminScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ManageDishScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ManagerScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ShowBillScreen

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
                    containerColor = Color("#312F2E".toColorInt()),
                    titleContentColor = Color.White
                ),
                title = {
                    Text("Cum Tứm Dim ", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    Image(painter = painterResource(id = R.drawable.logo_splash),
                        contentDescription = "kkk",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(10.dp)
                    )
                },
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
            composable(ROUTE_NAME.showbill.name) { ShowBillScreen(navController = navController) }
            composable(ROUTE_NAME.manager.name) { ManagerScreen(navController = navController) }
            composable(ROUTE_NAME.user.name) { UserScreen(navController = navController) }
        }
    }
}

@Composable
fun MyBottomAppBar(navigationController: NavHostController, selected: MutableState<String>) {
    BottomAppBar(containerColor = Color("#312C2C".toColorInt())) {
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
                    tint = if (selected.value == "home") Color("#FFB703".toColorInt()) else Color.White
                )
                Text(text = "Trang Chủ", color = if (selected.value == "home") Color("#FFB703".toColorInt()) else Color.White, fontSize = 11.sp)
            }
        }
        IconButton(
            onClick = {
                selected.value = "shoppingCall"
                navigationController.navigate(ROUTE_NAME.showbill.name) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = if (selected.value == "shoppingCall") Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
                    contentDescription = "ShoppingCall",
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == "shoppingCall") Color("#FFB703".toColorInt()) else Color.White
                )
                Text(text = "Thống Kê", color = if (selected.value == "shoppingCall") Color("#FFB703".toColorInt()) else Color.White, fontSize = 11.sp)
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
                    tint = if (selected.value == "notifications") Color("#FFB703".toColorInt()) else Color.White
                )
                Text(text = "Quản Lý", color = if (selected.value == "notifications") Color("#FFB703".toColorInt()) else Color.White, fontSize = 11.sp)
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
                    imageVector = if (selected.value == "profile") Icons.Filled.Person else Icons.Outlined.Person,
                    contentDescription = "Profile",
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == "profile") Color("#FFB703".toColorInt()) else Color.White
                )
                Text(text = "Hỗ Trợ", color = if (selected.value == "profile") Color("#FFB703".toColorInt()) else Color.White, fontSize = 11.sp)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    HomeScreen()
}
