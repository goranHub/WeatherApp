package com.example.wheatherapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author lllhr
 * @date 5/27/2021
 */

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCityWeather(city: CityEntity): Completable
}