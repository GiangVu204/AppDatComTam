package com.example.appdatcomtam.Screen.ScreenAdim.QLSanPham

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.rememberImagePainter
import com.example.appdatcomtam.LoaiMonAnDB
import com.example.appdatcomtam.Model.LoaiMonAnModel
import com.example.appdatcomtam.Model.MonAnModel
import com.example.appdatcomtam.R
import com.example.appdatcomtam.ROUTE_NAME

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteMonAnScreen(navController: NavController? = null) {
    val context = LocalContext.current

    // Khởi tạo cơ sở dữ liệu LoaiMonAnDB
    val db = Room.databaseBuilder(
        context,
        LoaiMonAnDB::class.java, "Com_Tam_1"
    ).allowMainThreadQueries().build()

    var listMonAnDB by remember {
        mutableStateOf(db.monAnDao().getAll())
    }
//delete
    var showDeleteConfirmation by remember { mutableStateOf(false) }
    var itemToDelete by remember { mutableStateOf<MonAnModel?>(null) }
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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF252121))
        ) {
            LazyColumn {
                items(listMonAnDB) { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF2F2D2D))
                            .clickable {
                                // Xử lý sự kiện khi nhấn vào mục sản phẩm
                            }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp, top = 28.dp, bottom = 28.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 15.dp),
                                text = item.idMonAn.toString(),
                                color = Color.White
                            )
                            Image(
                                painter = rememberImagePainter(data = item.imageUri),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(70.dp)
                                    .padding(end = 8.dp)
                                    .clip(RoundedCornerShape(18.dp)) // Bo góc ảnh
                            )
                            Text(
                                modifier = Modifier.weight(2f),
                                text = item.tenMonAn.orEmpty(),
                                color = Color.White,
                                fontSize = 19.sp
                            )
                            Text(
                                modifier = Modifier.weight(2f),
                                text = item.giaMonAn.toString(),
                                color = Color.White,
                                fontSize = 19.sp
                            )
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = "Edit",
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .weight(1f)
                                    .clickable {
                                        itemToDelete = item
                                        showDeleteConfirmation = true
                                    },
                                Color.White
                            )
                        }
                    }
                }
            }
            com.example.appdatcomtam.Screen.ScreenAdim.QLSanPham.DeleteMonAnConfirmationDialog(
                onConfirm = {
                    itemToDelete?.let {
                        // Xóa mục
                        db.monAnDao().delete(it)
                        listMonAnDB = db.monAnDao().getAll()
                    }
                },
                onCancel = {
                    showDeleteConfirmation = false
                    itemToDelete = null
                },
                isOpen = showDeleteConfirmation
            )
        }
    }
}

@Composable
fun DeleteMonAnConfirmationDialog(
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
    isOpen: Boolean
) {
    if (isOpen) {
        AlertDialog(
            onDismissRequest = onCancel,
            title = { Text("Xác nhận xóa") },
            text = { Text("Bạn có chắc chắn muốn xóa mục này không?") },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm()
                        onCancel()
                    }
                ) {
                    Text("Xóa")
                }
            },
            dismissButton = {
                Button(onClick = onCancel) {
                    Text("Hủy")
                }
            }
        )
    }
}