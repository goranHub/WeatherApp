package com.example.weatherapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author lllhr
 * @date 5/27/2021
 */
@Database(entities = [CityEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
