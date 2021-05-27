package com.example.wheatherapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author lllhr
 * @date 5/27/2021
 */
@Entity
data class CityEntity(
    @PrimaryKey
    val name :String,
    val base: String,
    val all: Int,
    val cod: Int,
    val lat: Double,
    val lon: Double,
    val dt: Int,
    val id: Int,
    val feelsLike: Double,
    val grndLevel: Int,
    val humidity: Int,
    val pressure: Int,
    val seaLevel: Int,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double,
    val country: String,
    val countryId: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int,
    val timezone: Int,
    val visibility: Int,
    val description: String,
    val icon: String,
    val wheatherId: Int,
    val main: String,
    val deg: Int,
    val gust: Double,
    val speed: Double
)
