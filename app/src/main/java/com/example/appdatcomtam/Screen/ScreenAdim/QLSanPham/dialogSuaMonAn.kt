package com.example.appdatcomtam.Screen.ScreenAdim.QLSanPham

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.appdatcomtam.Model.MonAnModel
import com.example.appdatcomtam.Model.LoaiMonAnModel
import com.example.appdatcomtam.ROUTE_NAME
import com.example.appdatcomtam.LoaiMonAnDB

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogSuaMonAn(navController: NavController?, monAn: MonAnModel?) {
    if (monAn == null) {
        // Handle the case where monAn is null (e.g., show an error message or navigate back)
        Toast.makeText(LocalContext.current, "Món ăn không tồn tại", Toast.LENGTH_SHORT).show()
        navController?.navigateUp()
        return
    }

    val context = LocalContext.current

    // Initialize the database
    val db = Room.databaseBuilder(
        context,
        LoaiMonAnDB::class.java, "Com_Tam_1"
    ).allowMainThreadQueries().build()

    val monAnDao = db.monAnDao()
    val loaiMonAnDao = db.loaiMonAnDao()

    var tenMonAnState by remember { mutableStateOf(monAn.tenMonAn ?: "") }
    var giaMonAnState by remember { mutableStateOf(monAn.giaMonAn?.toString() ?: "") }
    var loaiMonAnList by remember { mutableStateOf(listOf<LoaiMonAnModel>()) }
    var selectedLoaiMonAnState by remember { mutableStateOf(monAn.loaiMonAnId) }

    // Load the list of categories
    LaunchedEffect(Unit) {
        loaiMonAnList = loaiMonAnDao.getAll()
    }

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
            value = tenMonAnState,
            onValueChange = { tenMonAnState = it },
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
            value = giaMonAnState,
            onValueChange = { giaMonAnState = it },
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
                value = loaiMonAnList.find { it.uid == selectedLoaiMonAnState }?.tenLoaiMonAn ?: "",
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
                loaiMonAnList.forEach { loaiMonAn ->
                    DropdownMenuItem(
                        onClick = {
                            selectedLoaiMonAnState = loaiMonAn.uid
                            expanded = false
                        },
                        text = { Text(loaiMonAn.tenLoaiMonAn ?: "") }
                    )
                }
            }
        }

        // Update MonAn button
        Button(
            onClick = {
                val tenMonAn = tenMonAnState
                val giaMonAn = giaMonAnState.toDoubleOrNull()
                val loaiMonAnId = selectedLoaiMonAnState

                if (tenMonAn.isNotEmpty() && giaMonAn != null && loaiMonAnId != null) {
                    val updatedMonAn = monAn.copy(
                        tenMonAn = tenMonAn,
                        giaMonAn = giaMonAn,
                        loaiMonAnId = loaiMonAnId
                    )
                    monAnDao.update(updatedMonAn)
                    Toast.makeText(context, "Đã cập nhật món ăn", Toast.LENGTH_SHORT).show()
                    navController?.navigate(ROUTE_NAME.updatemonam.name)
                } else {
                    Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
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
            Text("Cập nhật", fontSize = 16.sp)
        }
    }
}
