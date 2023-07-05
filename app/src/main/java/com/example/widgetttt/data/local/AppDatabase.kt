package com.example.widgetttt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.widgetttt.data.local.dao.WeatherDao
import com.example.widgetttt.data.local.entity.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}