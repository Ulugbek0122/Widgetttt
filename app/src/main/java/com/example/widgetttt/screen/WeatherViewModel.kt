package com.example.widgetttt.screen

import com.example.widgetttt.data.local.entity.WeatherEntity
import kotlinx.coroutines.flow.SharedFlow

interface WeatherViewModel {

    val listSharedFlow: SharedFlow<List<WeatherEntity>>

    fun init()

    fun getWeather()
}