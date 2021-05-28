/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.weatherapp.di

import android.content.Context

import com.example.weatherapp.data.database.WeatherDao
import com.example.weatherapp.data.database.WeatherRoomDatabase
import com.example.weatherapp.domain.Repository
import com.example.weatherapp.ui.ViewModelFactory

/**
 * Enables injection of data sources.
 */
object Injection {

    fun provideWeatherDao(context: Context): WeatherDao {
        val database = WeatherRoomDatabase.fetchDatabase(context)
        return database.weatherDao()
    }

    fun provideRepository(context: Context): Repository {
        val dataSource = provideWeatherDao(context)
        return Repository(dataSource)
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideRepository(context)
        return ViewModelFactory(dataSource)
    }
}
