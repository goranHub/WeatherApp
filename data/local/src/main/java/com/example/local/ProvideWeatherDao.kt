package com.example.local

import android.content.Context
import androidx.room.Room
import com.example.local.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object ProvideWeatherDao {

    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        WeatherDatabase::class.java,
        "user_db"
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: WeatherDatabase) = db.weatherDao()
}

