package com.example.appdatcomtam


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Preview
@Composable
fun WelcomeScreen(navController: NavController? = null) {
    LaunchedEffect(key1 = true) {
        // Chờ 3 giây trước khi chuyển sang màn hình khác
        delay(6000)
        navController?.navigate("${ROUTE_NAME.login.name}")
    }

    getImage(Image = R.drawable.logo_splash)
}

@Composable
fun getImage(Image: Int){
    Image(
        painter = painterResource(id = Image),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)

    )
}


//Button(
//onClick =  {
//    navController?.navigate("${ROUTE_NAME.login.name}")
//},
//colors = ButtonDefaults.buttonColors(
//containerColor = Color.DarkGray,
//contentColor = Color.White
//),
//shape = RoundedCornerShape(8.dp),
//modifier = Modifier
//.wrapContentSize()
//.padding(16.dp)
//.height(50.dp)
//) {
//    Text(text = "Get Started")
//}