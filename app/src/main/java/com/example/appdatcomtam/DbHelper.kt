package com.example.appdatcomtam

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.appdatcomtam.Model.LoaiMonAnModel

@Database(entities = arrayOf(LoaiMonAnModel::class), version = 1)
abstract class LoaiMonAnDB : RoomDatabase() {
    abstract fun loaiMonAnDao(): LoaiMonAnDao
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