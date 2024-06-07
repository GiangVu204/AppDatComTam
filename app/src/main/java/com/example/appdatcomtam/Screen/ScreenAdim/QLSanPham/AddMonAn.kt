package com.example.appdatcomtam.Screen.ScreenAdim.QLSanPham

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.example.appdatcomtam.Model.MonAnModel
import com.example.appdatcomtam.ROUTE_NAME
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import com.example.appdatcomtam.Model.LoaiMonAnModel
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.core.graphics.toColorInt
import com.example.appdatcomtam.LoaiMonAnDB
import com.example.appdatcomtam.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMonAnScreen(navController: NavController? = null) {
    val context = LocalContext.current

    // Initialize MonAnDB
    val db = Room.databaseBuilder(
        context,
        LoaiMonAnDB::class.java, "Com_Tam_1"
    ).allowMainThreadQueries().build()

    val loaiMonAnDao = db.loaiMonAnDao()
    val monAnDao = db.monAnDao()

    // Remember state variables
    val tenMonAnState = remember { mutableStateOf("") }
    val giaMonAnState = remember { mutableStateOf("") }
    val loaiMonAnList = remember { mutableStateOf(listOf<LoaiMonAnModel>()) }
    val selectedLoaiMonAnState = remember { mutableStateOf<Int?>(null) }

    // Load data from database
    LaunchedEffect(Unit) {
        loaiMonAnList.value = loaiMonAnDao.getAll()
        selectedLoaiMonAnState.value = loaiMonAnList.value.firstOrNull()?.uid
    }
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
                            navController?.navigate(ROUTE_NAME.managerDish.name)
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
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                label = { Text("Tên món ăn", color = Color(0xFFFFB703)) },
                value = tenMonAnState.value,
                onValueChange = { tenMonAnState.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.Black,
                    containerColor = Color.White,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black
                )
            )

            OutlinedTextField(
                label = { Text("Giá món ăn", color = Color(0xFFFFB703)) },
                value = giaMonAnState.value,
                onValueChange = { giaMonAnState.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.Black,
                    containerColor = Color.White,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black
                )
            )

            // Spinner for loaiMonAn
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                var expanded by remember { mutableStateOf(false) }
                TextField(
                    value = loaiMonAnList.value.find { it.uid == selectedLoaiMonAnState.value }?.tenLoaiMonAn
                        ?: "",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Chọn loại món ăn", color = Color(0xFFFFB703)) },
                    trailingIcon = {
                        IconButton(onClick = { expanded = true }) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "DropDown")
                        }
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        disabledTextColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    loaiMonAnList.value.forEach { loaiMonAn ->
                        DropdownMenuItem(
                            onClick = {
                                selectedLoaiMonAnState.value = loaiMonAn.uid
                                expanded = false
                            },
                            text = { Text(loaiMonAn.tenLoaiMonAn ?: "") }
                        )
                    }
                }
            }

            // Add MonAn button
            Button(
                onClick = {
                    val tenMonAn = tenMonAnState.value
                    val giaMonAn = giaMonAnState.value.toDoubleOrNull()
                    val loaiMonAnId = selectedLoaiMonAnState.value

                    if (tenMonAn.isNotEmpty() && giaMonAn != null && loaiMonAnId != null) {
                        val monAn = MonAnModel(
                            tenMonAn = tenMonAn,
                            giaMonAn = giaMonAn,
                            loaiMonAnId = loaiMonAnId
                        )
                        monAnDao.insert(monAn)
                        Toast.makeText(context, "Đã thêm món ăn", Toast.LENGTH_SHORT).show()
                        navController?.navigate(ROUTE_NAME.updatemonam.name)
                    } else {
                        Toast.makeText(
                            context,
                            "Vui lòng nhập đầy đủ thông tin",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFB703),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 16.dp)
            ) {
                Text("Thêm", fontSize = 16.sp)
            }
        }
    }
}
