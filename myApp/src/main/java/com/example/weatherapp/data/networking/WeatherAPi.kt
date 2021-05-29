package com.example.weatherapp.data.networking

import com.example.weatherapp.data.response.ResponseByCity
import io.reactivex.Observable

/**
 * @author lllhr
 * @date 5/27/2021
 */
object WeatherAPi {

    const val API = "https://api.openweathermap.org/"
    private val service = OpenWeatherService.create()

    fun searchByCity(cityName: String): Observable<ResponseByCity> {
        // map to Entity
        return service.searchByCity(cityName)
            .map { responseByCity ->
                responseByCity
            }
    }

    fun searchByCurrentLocation(lat : Double, long: Double): Observable<ResponseByCity> {
        return service.searchByLatLon(lat, long)
    }
}