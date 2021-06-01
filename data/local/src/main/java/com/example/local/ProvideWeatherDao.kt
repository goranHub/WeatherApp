package com.example.local

import android.content.Context
import com.example.local.database.WeatherDatabase


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

