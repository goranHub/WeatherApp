package com.example.weatherapp.data.networking

import com.example.weatherapp.data.response.ResponseByCity
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author lllhr
 * @date 5/27/2021
 */
class NetworkDataSource @Inject constructor(
    private val weatherApi: WeatherApi
) {

    fun searchByCity(cityName: String): Observable<ResponseByCity> {
        // map to Entity
        return weatherApi.searchByCity(cityName)
            .map { responseByCity ->
                responseByCity
            }
    }

    fun searchByCurrentLocation(lat: Double, long: Double): Observable<ResponseByCity> {
        return weatherApi.searchByLatLon(lat, long)
    }
}