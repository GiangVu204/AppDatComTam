package com.example.appdatcomtam.Screen.ScreenAdim.QLSanPham

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.core.graphics.toColorInt
import com.example.appdatcomtam.LoaiMonAnDB
import com.example.appdatcomtam.R
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest


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
    val imageUriState = remember { mutableStateOf<Uri?>(null) }
    val tenMonAnState = remember { mutableStateOf("") }
    val giaMonAnState = remember { mutableStateOf("") }
    val loaiMonAnList = remember { mutableStateOf(listOf<LoaiMonAnModel>()) }
    val selectedLoaiMonAnState = remember { mutableStateOf<Int?>(null) }

    // Load data from database
    LaunchedEffect(Unit) {
        loaiMonAnList.value = loaiMonAnDao.getAll()
        selectedLoaiMonAnState.value = loaiMonAnList.value.firstOrNull()?.uid
    }

    // Create launcher for picking image from gallery
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUriState.value = uri
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
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image Món ăn
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(0.365f)
                    .clickable {
                        // Mở thư viện để chọn ảnh
                        launcher.launch("image/*")
                    }

//                    .offset(y = -30.dp)
                    .padding(bottom = 30.dp)
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
                                    floatArrayOf(10f, 10f),
                                    0f
                                )
                            )
                        )
                        drawContent()
                    }
                    .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
//                 ImageAddMonAn(Image = R.drawable.logo_splash)
                imageUriState.value?.let { uri ->
                    Image(
                        painter = rememberAsyncImagePainter(uri),
                        contentDescription = "Ảnh món ăn",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } ?: run {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.plus), contentDescription = "",
                        Modifier
                            .width(25.dp)
                            .height(25.dp))
                    Text(text = "Thêm hình ảnh", Modifier.fillMaxWidth(0.5f), color = Color.DarkGray)
                    }
                }
            }
            // Spinner for loaiMonAn
            Text(text = "Loại Món", Modifier.fillMaxWidth(), color = Color.White)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                var expanded by remember { mutableStateOf(false) }
                TextField(
                    value = loaiMonAnList.value.find { it.uid == selectedLoaiMonAnState.value }?.tenLoaiMonAn ?: "",
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
            
            Spacer(modifier = Modifier.padding(5.dp))

            // Giá món ăn
            Text(text = "Giá", Modifier.fillMaxWidth(), color = Color.White)
            OutlinedTextField(
                label = { Text("Giá món ăn", color = Color(0xFFFFB703)) },
                value = giaMonAnState.value,
                onValueChange = { giaMonAnState.value = it },
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

            //Name Món Ăn
            Text(text = "Tên món ăn", Modifier.fillMaxWidth(), color = Color.White)
            OutlinedTextField(
                label = { Text("Tên món ăn", color = Color(0xFFFFB703)) },
                value = tenMonAnState.value,
                onValueChange = { tenMonAnState.value = it },
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

            // Add MonAn button
            Button(
                onClick = {
                    val tenMonAn = tenMonAnState.value
                    val giaMonAn = giaMonAnState.value.toDoubleOrNull()
                    val loaiMonAnId = selectedLoaiMonAnState.value
                    val imageUri = imageUriState.value

                    if (tenMonAn.isNotEmpty() && giaMonAn != null && loaiMonAnId != null && imageUri != null) {
                        val monAn = MonAnModel(
                            tenMonAn = tenMonAn,
                            giaMonAn = giaMonAn,
                            loaiMonAnId = loaiMonAnId,
                            imageUri = imageUri.toString(), // Save image URI as a string
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
                    .fillMaxWidth(0.4f)
                    .height(80.dp)
                    .padding(top = 46.dp)
            ) {
                Text("Thêm", fontSize = 16.sp)
            }
        }
    }
}
