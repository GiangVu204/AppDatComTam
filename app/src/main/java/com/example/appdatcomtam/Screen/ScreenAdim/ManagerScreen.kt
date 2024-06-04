package com.example.appdatcomtam.Screen.ScreenAdim

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appdatcomtam.R
import com.example.appdatcomtam.ROUTE_NAME

@Composable
fun ManagerScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Quản lý món ăn
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { navController?.navigate("${ROUTE_NAME.managerDish.name}") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_splash),
                contentDescription = "Food Manager",
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.CenterStart)
            )
            Text(
                text = "Quản lý Món Ăn",
                style = MaterialTheme.typography.titleLarge,
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
                text = "Quản lý Loại Món Ăn",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 80.dp, top = 10.dp)
            )
        }
    }
}


