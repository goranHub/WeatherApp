package com.example.weatherapp.domain

import com.example.weatherapp.data.database.WeatherDao
import com.example.weatherapp.data.networking.WeatherAPi
import com.example.weatherapp.data.response.ResponseByCity
import io.reactivex.Observable

/**
 * @author lllhr
 * @date 5/28/2021
 */
class Repository (val weatherDao: WeatherDao, val weatherApi : WeatherAPi) {

    fun searchByCurrentLocation(lat : Double, long: Double): Observable<ResponseByCity> {
        return weatherApi.searchByCurrentLocation(lat, long)
    }


    fun observableCityEntity(name : String): Observable<ResponseByCity> {
        return WeatherAPi.searchByCity(name)
    }

}