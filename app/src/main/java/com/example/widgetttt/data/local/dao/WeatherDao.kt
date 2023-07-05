package com.example.widgetttt.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.widgetttt.data.local.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherDao {
    @Insert
    suspend fun insert(weatherEntity: WeatherEntity)

    @Delete
    suspend fun delete(weatherEntity: WeatherEntity)

    @Update
    suspend fun update(weatherEntity: WeatherEntity)

    @Query("select * from weather")
    suspend fun getWeather():List<WeatherEntity>
}