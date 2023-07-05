package com.example.widgetttt.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.widgetttt.data.local.entity.WeatherEntity
import com.example.widgetttt.repository.WeatherRepository
import com.example.widgetttt.screen.WeatherViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModelImpl @Inject constructor(
    private var weatherRepository: WeatherRepository
): WeatherViewModel,ViewModel(){
    override val listSharedFlow = MutableSharedFlow<List<WeatherEntity>>()

    override fun init() {
        viewModelScope.launch {
            weatherRepository.insert()
        }
    }

    override fun getWeather(){
        viewModelScope.launch {
            listSharedFlow.emit(weatherRepository.getList())
        }
    }

}