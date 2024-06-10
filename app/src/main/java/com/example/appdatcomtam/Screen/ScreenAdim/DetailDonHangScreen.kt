package com.example.appdatcomtam.Screen.ScreenAdim

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdatcomtam.R

var textColor = Color.White
@Composable
fun DetailDonDangScreen(navController: NavController? = null) {
    LazyColumn (
        Modifier
            .fillMaxSize()
            .background(Color(0xFF252120))
            .padding(15.dp)
    ) {
        item {
            Nut()
        }
        item {
            MonChinh()
        }
        item {
            MonThem()
        }
        item{
            Topping()
        }
        item{
            Khac()
        }
        item {
            DiaChi()
        }
        item{
            ThanhToan()
        }
    }
}

@Composable
fun Nut(){
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F2D2D))
        ) {
            Text(
                text = "Xác nhận",
                color = textColor
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F2D2D))
        ) {
            Text(
                text = "Huỷ",
                color = textColor
            )
        }
    }
}

@Composable
fun MonChinh(){
    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = "Món chính",
        color = textColor,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
    )
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "1",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.suon_bi),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(Modifier.width(10.dp))
        Column{
            Text(
                text = "Sườn bì",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "56K",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(60.dp))
        Column {
            Text(
                text = "02",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
    Spacer(Modifier.height(10.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "2",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.bi_cha),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(Modifier.width(10.dp))
        Column{
            Text(
                text = "Bì chả",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "25K",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(70.dp))
        Column {
            Text(
                text = "01",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
    Spacer(Modifier.height(10.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "3",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.bi_trung),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(Modifier.width(10.dp))
        Column{
            Text(
                text = "Bì trung",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "56K",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(60.dp))
        Column {
            Text(
                text = "01",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun MonThem(){
    Spacer(modifier = Modifier.height(8.dp))
    Divider(color = Color.White, thickness = 1.dp)
    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = "Món thêm",
        color = textColor,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
    )
    Spacer(Modifier.height(15.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "1",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.suon),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(Modifier.width(10.dp))
        Column{
            Text(
                text = "Sườn",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "10K",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(80.dp))
        Column {
            Text(
                text = "02",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
    Spacer(Modifier.height(10.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "2",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.suon_bi),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
                )
        }
        Column(
            Modifier.padding(horizontal = 5.dp)
        ){
            Text(
                text = "Sườn mỡ",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "10K",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(60.dp))
        Column {
            Text(
                text = "02",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
    Spacer(Modifier.height(10.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "3",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.trung),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Column(
            Modifier.padding(horizontal = 5.dp)
        ){
            Text(
                text = "Trứng",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "5K",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(80.dp))
        Column {
            Text(
                text = "02",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun Topping() {
    Spacer(modifier = Modifier.height(8.dp))
    Divider(color = Color.White, thickness = 1.dp)
    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = "Topping",
        color = textColor,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
    )
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "1",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.mo_hanh),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Column(
            Modifier.padding(horizontal = 5.dp)
        ) {
            Text(
                text = "Mỡ hành",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "Free",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(60.dp))
        Column {
            Text(
                text = "02",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
    Spacer(Modifier.height(10.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "2",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.top_mo),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Column(
            Modifier.padding(horizontal = 5.dp)
        ) {
            Text(
                text = "Tóp mỡ",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "Free",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(80.dp))
        Column {
            Text(
                text = "02",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun Khac() {
    Spacer(modifier = Modifier.height(8.dp))
    Divider(color = Color.White, thickness = 1.dp)
    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = "Khác",
        color = textColor,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
    )
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "1",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.khan_lanh),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Column(
            Modifier.padding(horizontal = 5.dp)
        ) {
            Text(
                text = "Khăn lạnh",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "2K",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(60.dp))
        Column {
            Text(
                text = "02",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
    Spacer(Modifier.height(10.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2F2D2D)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = "2",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            Modifier.padding(horizontal = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.khan_giay),
                contentDescription = null,
                Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Column(
            Modifier.padding(horizontal = 5.dp)
        ) {
            Text(
                text = "Khăn giay",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "Free",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
        Spacer(Modifier.width(60.dp))
        Column {
            Text(
                text = "02",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun DiaChi(){
    Spacer(modifier = Modifier.height(8.dp))
    Divider(color = Color.White, thickness = 1.dp)
    Spacer(Modifier.height(20.dp))
    Column {
        Row {
            Text(
                text = "Số nhà: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "54",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "Đường: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "14",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "Phường: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "Đông Hưng Thuận",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "Quận: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "12",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "Thành phố: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "Hồ Chí Minh",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
    }
}

@Composable
fun ThanhToan(){
    Spacer(modifier = Modifier.height(8.dp))
    Divider(color = Color.White, thickness = 1.dp)
    Spacer(Modifier.height(20.dp))
    Column {
        Row {
            Text(
                text = "Giờ: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "13h45p",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "SĐT: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "0348512697",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "Tổng số lượng món ăn: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "5",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "Tống số lượng món ăn thêm: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "3",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "Tổng số lượng Topping: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "2",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "Tổng số lượng khác: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "2",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
        Row {
            Text(
                text = "Tổng tiền: ",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
            Text(
                text = "133K",
                color = textColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewDetailDonHang(){
    DetailDonDangScreen()
}