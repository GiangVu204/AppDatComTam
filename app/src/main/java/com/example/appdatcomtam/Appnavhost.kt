package com.example.appdatcomtam


import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.room.Room
import com.example.appdatcomtam.Screen.ScreenAdim.DetailDonDangScreen
import com.example.appdatcomtam.Screen.ScreenAdim.HomeAdminScreen
import com.example.appdatcomtam.Screen.HomeScreen
import com.example.appdatcomtam.Screen.MenuScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ManageDishScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ManagerCategoriesScreen
import com.example.appdatcomtam.Screen.ScreenAdim.ManagerScreen
import com.example.appdatcomtam.Screen.ScreenAdim.QLLoaiSP.AddLoaiSPScreen
import com.example.appdatcomtam.Screen.ScreenAdim.QLLoaiSP.DeleteLoaiSPScreen
import com.example.appdatcomtam.Screen.ScreenAdim.QLLoaiSP.DialogSuaSP
import com.example.appdatcomtam.Screen.ScreenAdim.QLLoaiSP.UpdateLoaiSPScreen
import com.example.appdatcomtam.Screen.ScreenAdim.QLSanPham.AddMonAnScreen
import com.example.appdatcomtam.Screen.ScreenAdim.QLSanPham.DeleteMonAnScreen
import com.example.appdatcomtam.Screen.ScreenAdim.QLSanPham.UpdateMonAnScreen
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
    managerDish,
    addloaisp,
    updateloaisp,
    deleteloaisp,
    addmonan,
    updatemonam,
    deletemonan,
    dialogsualoaimonan
}

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        LoaiMonAnDB::class.java, "student-db"
    ).allowMainThreadQueries().build()
    NavHost(
        navController = navController,
        startDestination = ROUTE_NAME.home.name
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
        composable(ROUTE_NAME.addloaisp.name) {
            AddLoaiSPScreen(navController)
        }
        composable("${ROUTE_NAME.dialogsualoaimonan.name}/{uid}", arguments = listOf(navArgument("uid") { type = NavType.IntType })) { backStackEntry ->
            val uid = backStackEntry.arguments?.getInt("uid")
            val item = db.loaiMonAnDao().loadAllByIds(intArrayOf(uid ?: 0)).firstOrNull()
            DialogSuaSP(navController, loaiMonAn = item)
        }
        composable(ROUTE_NAME.updateloaisp.name) {
            UpdateLoaiSPScreen(navController)
        }
        composable(ROUTE_NAME.deleteloaisp.name) {
            DeleteLoaiSPScreen(navController)
        }
        composable(ROUTE_NAME.addmonan.name) {
            AddMonAnScreen(navController)
        }
        composable(ROUTE_NAME.updatemonam.name) {
            UpdateMonAnScreen(navController)
        }
        composable(ROUTE_NAME.deletemonan.name) {
            DeleteMonAnScreen(navController)
        }


    }
}