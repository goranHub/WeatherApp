package com.example.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * @author lllhr
 * @date 5/27/2021
 */
@Database(entities = [CityEntity::class, MyLocationEntity::class], version = 1, exportSchema = true)
@TypeConverters(MyLocationTypeConverters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
