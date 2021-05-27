package com.example.wheatherapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author lllhr
 * @date 5/27/2021
 */
@Database(entities = [CityEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
