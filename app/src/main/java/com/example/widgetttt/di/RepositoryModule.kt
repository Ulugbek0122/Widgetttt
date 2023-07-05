package com.example.weatherwidget.di

import com.example.widgetttt.repository.WeatherRepository
import com.example.widgetttt.repository.impl.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    
    @[Binds Singleton]
    fun weatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

}