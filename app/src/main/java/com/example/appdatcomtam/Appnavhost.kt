package com.example.appdatcomtam


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.appdatcomtam.Screen.ScreenAdim.DetailDonDangScreen
import com.example.appdatcomtam.Screen.ScreenAdim.HomeAdminScreen
import com.example.appdatcomtam.Screen.HomeScreen
import com.example.appdatcomtam.Screen.MenuScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ManageDishScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ManagerCategoriesScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ManagerScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ShowBillScreen
import com.example.appdatcomtam.Screen.SignUpScreen
import com.example.appdatcomtam.Screen.UserScreen

enum class ROUTE_NAME {
    welcome,
    login,
    home,
    signup,
    user,
    menu,
    homeAdmin,
    detaildonhang,
    showbill,
    manager,
    managerCategories,
    managerDish
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
        composable(ROUTE_NAME.signup.name) {
            SignUpScreen(navController)
        }
        composable(ROUTE_NAME.home.name) {
            HomeScreen(navController)
        }
        composable(ROUTE_NAME.user.name) {
            UserScreen(navController)
        }
        composable(ROUTE_NAME.menu.name) {
            MenuScreen(navController)
        }
        composable(ROUTE_NAME.homeAdmin.name) {
            HomeAdminScreen(navController)
        }
        composable(ROUTE_NAME.detaildonhang.name) {
            DetailDonDangScreen(navController)
        }
        composable(ROUTE_NAME.showbill.name) {
            ShowBillScreen(navController)
        }
        composable(ROUTE_NAME.manager.name) {
            ManagerScreen(navController)
        }
        composable(ROUTE_NAME.managerCategories.name) {
            ManagerCategoriesScreen(navController)
        }
        composable(ROUTE_NAME.managerDish.name) {
            ManageDishScreen(navController)
        }


    }
}