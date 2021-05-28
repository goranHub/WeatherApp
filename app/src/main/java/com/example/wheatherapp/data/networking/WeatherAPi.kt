package com.example.wheatherapp.data.networking

import com.example.wheatherapp.data.database.CityEntity
import com.example.wheatherapp.domain.toEntity
import com.example.wheatherapp.domain.toModel
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