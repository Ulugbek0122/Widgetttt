package com.example.widgetttt.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var city:String,
    var temp:String,
    var weather:String,
    var timeSunset:String,
    var timeSunrase:String
)
