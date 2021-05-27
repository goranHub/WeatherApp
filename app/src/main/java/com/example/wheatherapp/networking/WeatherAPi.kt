package com.example.wheatherapp.networking

import com.example.wheatherapp.database.CityEntity
import io.reactivex.Single

/**
 * @author lllhr
 * @date 5/27/2021
 */
object WeatherAPi {
    const val API = "https://api.openweathermap.org/"

    private val service = OpenWheatherService.create()

    fun searchByCity(cityName : String): Single<CityEntity> {
        // map to Entity
        return service.searchByCity(cityName)
            .map {
                val name = it.name ?: ""
                val base = it.base ?: ""
                val all = it.clouds?.all ?: 0
                val cod = it.cod ?: 0
                val lat = it.coord?.lat ?: 0.0
                val lon= it.coord?.lon ?: 0.0
                val dt = it.dt ?: 0
                val id = it.id ?: 0
                val feelsLike= it.main?.feels_like ?: 0.0
                val grndLevel = it.main?.grnd_level ?: 0
                val humidity = it.main?.humidity ?: 0
                val pressure = it.main?.pressure ?: 0
                val seaLevel = it.main?.sea_level ?: 0
                val temp= it.main?.temp ?: 0.0
                val tempMax= it.main?.temp_max ?: 0.0
                val tempMin= it.main?.temp_min ?: 0.0
                val country = it.sys?.country ?: ""
                val countryId = it.sys?.id ?: 0
                val sunrise = it.sys?.sunset ?: 0
                val sunset = it.sys?.sunset ?: 0
                val type = it.sys?.type ?: 0
                val timezone = it.timezone ?: 0
                val visibility = it.visibility ?: 0

                val description = it.weather?.first()?.description ?: ""
                val icon = it.weather?.first()?.icon ?: ""
                val wheatherId = it.weather?.first()?.id ?: 0
                val main= it.weather?.first()?.main ?: ""


                val deg = it.wind?.deg ?: 0
                val gust= it.wind?.gust ?: 0.0
                val speed= it.wind?.speed ?: 0.0


                CityEntity(name,base,all,cod,lat,lon,dt,id,feelsLike,grndLevel,humidity,pressure,seaLevel,
                temp,tempMax,tempMin,country,countryId,sunrise,sunset,type,timezone,visibility,description,
                icon,wheatherId,main,deg,gust,speed)
            }

    }


}