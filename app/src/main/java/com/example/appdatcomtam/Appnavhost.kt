package com.example.appdatcomtam


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController

enum class ROUTE_NAME {
    welcome,
    login,
    home,
    signup,

}

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ROUTE_NAME.welcome.name
    ) {
        composable(ROUTE_NAME.welcome.name) {
            WelcomeScreen(navController)
        }
        composable(ROUTE_NAME.login.name) {
            LoginScreen(navController)
        }

    }
}