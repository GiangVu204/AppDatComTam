//package com.example.appdatcomtam.Model
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.ForeignKey
//import androidx.room.PrimaryKey

//@Entity
//data class MonAnModel(
//    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
//    @ColumnInfo(name = "LoaiMon1") var LoaiMon1: String,
//    @ColumnInfo(name = "LoaiMon2") var LoaiMon2: String,
//    @ColumnInfo(name = "TenMonAn") var TenMonAn: String,
//    @ColumnInfo(name = "Gia") var Gia: Int,
//
//)

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
    @ColumnInfo(name = "loaiMonAnId") var loaiMonAnId: Int
)
