package com.example.appdatcomtam.Screen.ScreenAdim

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview(showBackground = true)
@Composable
fun HomeAdminScreen(navController: NavController? = null) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121))

    ) {
        Column(
            modifier = Modifier
                .padding(20.dp),


            ) {
            Box() {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Today : 19 - 05 - 2023",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = Color.White
                    )
                    Text(
                        text = "Số Lượng Đơn : 2 ",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = Color.White
                    )
                    Row() {
                        Text(
                            text = "Doanh Thu : ",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            color = Color.White
                        )
                        Text(
                            text = "320.000d",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            color = Color(0xFFFE724C),
                        )
                    }
                    Spacer(modifier = Modifier.padding(vertical = 30.dp))
                    Row(
                        modifier = Modifier

                            .fillMaxWidth()
                            .height(110.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xFF2F2D2D))
                            ,

                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                            Text(
                                text = "Đơn hàng CT2E22E  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "Trạng Thái  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }


                        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                            Text(
                                text = "|| 162.000d  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "   Từ Chối  ", color = Color.Red,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Row(
                        modifier = Modifier

                            .fillMaxWidth()
                            .height(110.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xFF2F2D2D)),

                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                            Text(
                                text = "Đơn hàng CT2E22E  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "Trạng Thái  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }


                        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                            Text(
                                text = "|| 162.000d  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "   Từ Chối  ", color = Color.Red,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Row(
                        modifier = Modifier

                            .fillMaxWidth()
                            .height(110.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xFF2F2D2D)),

                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                            Text(
                                text = "Đơn hàng CT2E22E  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "Trạng Thái  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }


                        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                            Text(
                                text = "|| 162.000d  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "   Từ Chối  ", color = Color.Red,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Row(
                        modifier = Modifier

                            .fillMaxWidth()
                            .height(110.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xFF2F2D2D)),

                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                            Text(
                                text = "Đơn hàng CT2E22E  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "Trạng Thái  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }


                        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                            Text(
                                text = "|| 162.000d  ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "   Từ Chối  ", color = Color.Red,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }

                }


            }

        }
    }
}