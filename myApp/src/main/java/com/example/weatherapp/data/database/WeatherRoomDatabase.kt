package com.example.weatherapp.data.database

import android.content.Context
import androidx.room.Room

/**
 * @author lllhr
 * @date 5/27/2021
 */
object WeatherRoomDatabase {
    private var database: WeatherDatabase? = null

    fun fetchDatabase(context: Context): WeatherDatabase {
        val localDatabaseCopy = database
        return if (localDatabaseCopy != null) {
            localDatabaseCopy
        } else {
            val localDatabase = Room.databaseBuilder(
                context,
                WeatherDatabase::class.java, "weather_database"
            ).build()
            database = localDatabase
            localDatabase
        }
    }
}