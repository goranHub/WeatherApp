package com.example.weatherapp.data.networking

import com.example.weatherapp.data.database.CityEntity
import com.example.weatherapp.domain.toEntity
import com.example.weatherapp.domain.toModel
import io.reactivex.Observable

/**
 * @author lllhr
 * @date 5/27/2021
 */
object WeatherAPi {
    const val API = "https://api.openweathermap.org/"

    private val service = OpenWheatherService.create()

    fun searchByCity(cityName: String): Observable<CityEntity> {

        // map to Entity
        return service.searchByCity(cityName)
            .map { responseByCity ->
                val model = responseByCity.toModel()
                model.toEntity()
            }
    }

}