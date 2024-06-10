package com.example.appdatcomtam.Screen.ScreenAdim.QLSanPham

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import coil.compose.rememberImagePainter
import com.example.appdatcomtam.Model.MonAnModel
import com.example.appdatcomtam.Model.LoaiMonAnModel
import com.example.appdatcomtam.ROUTE_NAME
import com.example.appdatcomtam.LoaiMonAnDB
import com.example.appdatcomtam.R

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
    var imageUriState by remember { mutableStateOf<Uri?>(Uri.parse(monAn.imageUri)) }

    // Load the list of categories
    LaunchedEffect(Unit) {
        loaiMonAnList = loaiMonAnDao.getAll()
    }

    // Image Picker Launcher
    val imagePickerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUriState = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Image dialog sua mon an
        Box(
            modifier = Modifier
                .fillMaxWidth(0.45f)
                .fillMaxHeight(0.25f)
                .clickable { imagePickerLauncher.launch("image/*") }
                .drawWithContent {
                    drawRect(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, Color.Red, Color.Transparent),
                            startX = 0f,
                            endX = size.width,
                            tileMode = TileMode.Repeated
                        ),
                        style = Stroke(
                            width = 2.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(
                                floatArrayOf(50f, 50f),
                                0f
                            )
                        )
                    )
                    drawContent()
                }
                .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.CenterStart
        ) {
            if (imageUriState != null) {
                Image(
                    painter = rememberImagePainter(data = imageUriState),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.image_dialog_sua_mon_an),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.padding(top = 30.dp))

        //Name mon an
        Text(text = "Tên món ăn", Modifier.fillMaxWidth(), color = Color.White)
        OutlinedTextField(
            label = { Text("Tên món ăn", color = Color(0xFFFFB703)) },
            value = tenMonAnState,
            onValueChange = { tenMonAnState = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            textStyle = TextStyle(fontSize = 13.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.Black,
                containerColor = Color.White,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.padding(5.dp))

        //Gia mon an
        Text(text = "Giá", Modifier.fillMaxWidth(), color = Color.White)
        OutlinedTextField(
            label = { Text("Giá món ăn", color = Color(0xFFFFB703)) },
            value = giaMonAnState,
            onValueChange = { giaMonAnState = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            textStyle = TextStyle(fontSize = 13.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.Black,
                containerColor = Color.White,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.padding(5.dp))

        // Spinner for loaiMonAn
        Text(text = "Loại Món", Modifier.fillMaxWidth(), color = Color.White)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            var expanded by remember { mutableStateOf(false) }
            TextField(
                value = loaiMonAnList.find { it.uid == selectedLoaiMonAnState }?.tenLoaiMonAn ?: "",
                onValueChange = {},
                readOnly = true,
                label = { Text("Chọn loại món ăn", color = Color(0xFFFFB703), fontSize = 10.sp) },
                trailingIcon = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "DropDown")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
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

        Spacer(modifier = Modifier.padding(25.dp))

        // Update MonAn button
        Button(
            onClick = {
                val tenMonAn = tenMonAnState
                val giaMonAn = giaMonAnState.toDoubleOrNull()
                val loaiMonAnId = selectedLoaiMonAnState
                val imageUri = imageUriState.toString()

                if (tenMonAn.isNotEmpty() && giaMonAn != null && loaiMonAnId != null) {
                    val updatedMonAn = monAn.copy(
                        tenMonAn = tenMonAn,
                        giaMonAn = giaMonAn,
                        loaiMonAnId = loaiMonAnId,
                        imageUri = imageUri
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
                .fillMaxWidth(0.4f)
                .height(55.dp)
                .padding(top = 16.dp)
        ) {
            Text("Lưu", fontSize = 16.sp)
        }
    }
}
