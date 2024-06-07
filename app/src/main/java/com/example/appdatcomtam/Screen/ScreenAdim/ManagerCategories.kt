package com.example.appdatcomtam.Screen.ScreenAdim

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.appdatcomtam.R
import com.example.appdatcomtam.ROUTE_NAME

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManagerCategoriesScreen(navController: NavController? = null) {

    Column {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color("#252121".toColorInt()),
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = {
                            navController?.navigate(ROUTE_NAME.home.name)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logo_splash),
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(10.dp)
                    )

                }
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(color = Color.Black)
        )


    Column(
        modifier = Modifier
            .fillMaxSize()
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
}}