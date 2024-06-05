package com.example.appdatcomtam.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class LoaiMonAnModel (

    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "tenLoaiMonAn") var tenLoaiMonAn: String?
)