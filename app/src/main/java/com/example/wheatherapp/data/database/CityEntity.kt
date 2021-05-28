package com.example.wheatherapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author lllhr
 * @date 5/27/2021
 */
@Entity
data class CityEntity(
    @PrimaryKey(autoGenerate = false)
    var base: String,
    var all: Int,
    var cod: Int,
    var lat: Double,
    var lon: Double,
    var dt: Int,
    var id: Int,
    var feelsLike: Double,
    var grndLevel: Int,
    var humidity: Int,
    var pressure: Int,
    var seaLevel: Int,
    var temp: Double,
    var tempMax: Double,
    var tempMin: Double,
    var country: String,
    var countryId: Int,
    var sunrise: Int,
    var sunset: Int,
    var type: Int,
    var timezone: Int,
    var visibility: Int,
    var description: String,
    var icon: String,
    var weatherId: Int,
    var main: String,
    var deg: Int,
    var gust: Double,
    var speed: Double
)
