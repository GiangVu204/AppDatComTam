package com.example.appdatcomtam.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdatcomtam.R // thêm dòng này để import resource

@Preview(showBackground = true)
@Composable
fun UserScreen(navController: NavController? = null) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF252121)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.padding(horizontal = 15.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logozaloreal),
                        contentDescription = "logozalo",
                        modifier = Modifier.size(55.dp)
                    )
                    Text(
                        text = "0879175310",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logogmailreal),
                        contentDescription = "logomail",
                        modifier = Modifier.size(55.dp)
                    )
                    Text(
                        text = "dangnmph34649@fpt.edu.vn",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(vertical = 10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "", modifier = Modifier.padding(horizontal = 15.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logophone),
                        contentDescription = "logophone",
                        modifier = Modifier.size(55.dp)
                    )
                    Text(
                        text = "0879175310",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
        }
    }
}