package com.example.appdatcomtam.Screen.ScreenAdim.QLLoaiSP

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.room.Room
import com.example.appdatcomtam.LoaiMonAnDB
import com.example.appdatcomtam.LoaiMonAnDao
import com.example.appdatcomtam.Model.LoaiMonAnModel
import com.example.appdatcomtam.R
import com.example.appdatcomtam.ROUTE_NAME

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddLoaiSPScreen(navController: NavController? = null) {
    val context = LocalContext.current

    // Khởi tạo cơ sở dữ liệu LoaiMonAnDB
    val db = Room.databaseBuilder(
        context,
        LoaiMonAnDB::class.java, "Com_Tam_1"
    ).allowMainThreadQueries().build()


    // Lưu trạng thái của EditText
    val tenLoaiMonAnState = remember { mutableStateOf("") }
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
                        navController?.navigate(ROUTE_NAME.managerCategories.name)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White ,
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
            .background(Color(0xFF252121)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        OutlinedTextField(
            label = { Text("Nhập loại món ăn", color = Color(0xFFFFB703)) },
            value = tenLoaiMonAnState.value,
            onValueChange = { tenLoaiMonAnState.value = it },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp),
            textStyle = TextStyle(color = Color.Black),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.Black,
                containerColor = Color.White,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )






        // Nút Button để thêm loại món ăn
        Button(

            onClick = {
                val tenLoaiMonAn = tenLoaiMonAnState.value
                if (tenLoaiMonAn.isNotEmpty()) {
                    // Tạo một đối tượng LoaiMonAnModel từ dữ liệu đã nhập
                    val loaiMonAn = LoaiMonAnModel(tenLoaiMonAn = tenLoaiMonAn)
                    // Thêm loại món ăn vào cơ sở dữ liệu
                    db.loaiMonAnDao().insert(loaiMonAn)
                    // Hiển thị thông báo đã thêm
                    Toast.makeText(context, "Đã thêm loại món ăn", Toast.LENGTH_SHORT).show()
                    // Sau khi thêm, chuyển hướng đến màn hình khác
                    navController?.navigate(ROUTE_NAME.updateloaisp.name)
                } else {
                    // Hiển thị thông báo yêu cầu nhập loại món ăn
                    Toast.makeText(context, "Vui lòng nhập loại món ăn", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFB703),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .height(50.dp)
                .padding(top = 16.dp)
                .border(2.dp, Color(0xFFFFB703), RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp)

        ) {
            Text("Thêm")
        }

    }
}
}