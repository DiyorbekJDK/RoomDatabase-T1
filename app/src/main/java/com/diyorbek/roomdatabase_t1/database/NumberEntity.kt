package com.diyorbek.roomdatabase_t1.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Number Table")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val number: String
) : Parcelable
