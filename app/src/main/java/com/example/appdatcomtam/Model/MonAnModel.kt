package com.example.appdatcomtam.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = LoaiMonAnModel::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("loaiMonAnId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class MonAnModel(
    @PrimaryKey(autoGenerate = true) var idMonAn: Int = 0,
    @ColumnInfo(name = "tenMonAn") var tenMonAn: String,
    @ColumnInfo(name = "giaMonAn") var giaMonAn: Double,
    @ColumnInfo(name = "loaiMonAnId") var loaiMonAnId: Int,
    @ColumnInfo(name = "image") var imageUri: String,
)
