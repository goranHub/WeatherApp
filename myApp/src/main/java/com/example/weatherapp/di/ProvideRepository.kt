package com.example.weatherapp.di

import com.example.weatherapp.data.database.WeatherDao
import com.example.weatherapp.data.networking.NetworkDataSource
import com.example.weatherapp.domain.MyLocationManager
import com.example.weatherapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @author lllhr
 * @date 6/1/2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object ProvideRepository {

    @Provides
    @Singleton
    fun provideRep(
        weatherDao: WeatherDao,
        weatherApi: NetworkDataSource,
        myLocationManager: MyLocationManager
    ): Repository {

        return Repository(weatherDao, weatherApi, myLocationManager)
    }
}