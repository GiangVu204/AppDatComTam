package com.example.appdatcomtam

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.appdatcomtam.Model.LoaiMonAnModel
import com.example.appdatcomtam.Model.MonAnModel

@Database(entities = [MonAnModel::class, LoaiMonAnModel::class], version = 1)
abstract class MonAnDB : RoomDatabase() {
    abstract fun monAnDao(): MonAnDao
}
@Dao
interface MonAnDao {
    @Query("SELECT * FROM MonAnModel")
    fun getAllMonAn(): List<MonAnModel>

    @Query("SELECT * FROM MonAnModel WHERE idMonAn IN (:monAnIds)")
    fun loadAllByIds(monAnIds: IntArray): List<MonAnModel>

    @Query("SELECT * FROM MonAnModel WHERE loaiMonAnId = :loaiMonAnId")
    fun findByLoaiMonAnId(loaiMonAnId: Int): List<MonAnModel>

    @Insert
    fun insertMonAn(vararg monAn: MonAnModel)

    @Update
    fun updateMonAn(monAn: MonAnModel)

    @Delete
    fun deleteMonAn(monAn: MonAnModel)

    @Query("SELECT * FROM LoaiMonAnModel")
    fun getAllLoaiMonAn(): List<LoaiMonAnModel>

    @Insert
    fun insertLoaiMonAn(vararg loaiMonAn: LoaiMonAnModel)
}