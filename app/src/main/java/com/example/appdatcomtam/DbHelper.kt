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

@Database(entities = [LoaiMonAnModel::class, MonAnModel::class], version = 1)
abstract class LoaiMonAnDB : RoomDatabase() {
    abstract fun loaiMonAnDao(): LoaiMonAnDao
    abstract fun monAnDao(): MonAnDao

}
@Dao
interface LoaiMonAnDao {
    @Query("SELECT * FROM LoaiMonAnModel")
    fun getAll(): List<LoaiMonAnModel>

    @Query("SELECT * FROM LoaiMonAnModel WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<LoaiMonAnModel>

    @Insert
    fun insert(vararg users: LoaiMonAnModel)

    @Update
    fun update(user: LoaiMonAnModel)

    @Delete
    fun delete(user: LoaiMonAnModel)
}

@Dao
interface MonAnDao {
    @Query("SELECT * FROM MonAnModel")
    fun getAll(): List<MonAnModel>

    @Query("SELECT * FROM MonAnModel WHERE idMonAn IN (:monAnIds)")
    fun loadAllByIds(monAnIds: IntArray): List<MonAnModel>

    @Query("SELECT * FROM MonAnModel WHERE loaiMonAnId = :loaiMonAnId")
    fun findByLoaiMonAnId(loaiMonAnId: Int): List<MonAnModel>

    @Insert
    fun insert(vararg monAn: MonAnModel)

    @Update
    fun update(monAn: MonAnModel)

    @Delete
    fun delete(monAn: MonAnModel)
}