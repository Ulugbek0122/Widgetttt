package com.example.widgetttt.repository

import com.example.widgetttt.data.local.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

   suspend fun insert()

   suspend fun getList():List<WeatherEntity>
}