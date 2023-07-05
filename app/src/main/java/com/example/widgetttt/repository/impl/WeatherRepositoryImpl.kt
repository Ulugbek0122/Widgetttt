package com.example.widgetttt.repository.impl

import android.util.Log
import com.example.widgetttt.data.local.AppDatabase
import com.example.widgetttt.data.local.dao.WeatherDao
import com.example.widgetttt.data.local.entity.WeatherEntity
import com.example.widgetttt.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private var weatherDao: WeatherDao
) : WeatherRepository {
    override suspend fun insert(){
        weatherDao.insert(
            WeatherEntity(
                0, "Tashkent",
                "38", "Cloudy", "05:10", "20:00"
            )
        )
    }

    override suspend fun getList():List<WeatherEntity>{
        return weatherDao.getWeather()
    }
}