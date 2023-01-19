package com.diyorbek.roomdatabase_t1.database

import android.content.Context
import androidx.room.*

@Database(entities = [NumberEntity::class], version = 1, exportSchema = false)
abstract class NumberDatabase : RoomDatabase() {
    abstract val dao: NumberDao

    companion object {
        @Volatile
        private var instance: NumberDatabase? = null

        operator fun invoke(context: Context): NumberDatabase {
            return instance ?: synchronized(Any()) {
                instance ?: createDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun createDatabase(context: Context): NumberDatabase {
            return Room.databaseBuilder(
                context,
                NumberDatabase::class.java,
                "Number.db"
            ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        }
    }
}