package com.diyorbek.roomdatabase_t1.database

import androidx.room.*

@Dao
interface NumberDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveNumber(number: NumberEntity)

    @Query("SELECT * FROM `Number Table` ORDER BY id DESC")
    fun getAllNumbers(): List<NumberEntity>

    @Update
    fun updateNumber(number: NumberEntity)

    @Delete
    fun deleteNumber(number: NumberEntity)
}