package com.example.wheatherapp.domain

import com.example.wheatherapp.data.database.CityEntity
import com.example.wheatherapp.data.model.WeatherByCityModel
import com.example.wheatherapp.data.response.ResponseByCity

/**
 * @author lllhr
 * @date 5/28/2021
 */


fun ResponseByCity.toModel(): WeatherByCityModel {

    val base = base ?: ""
    val all = clouds?.all ?: 0
    val cod = cod ?: 0

    val lat = coord?.lat ?: 0.0
    val lon = coord?.lon ?: 0.0

    val dt = dt ?: 0
    val id = id ?: 0

    val feelsLike = main?.feelsLike ?: 0.0
    val grndLevel = main?.grndLevel ?: 0
    val humidity = main?.humidity ?: 0
    val pressure = main?.pressure ?: 0
    val seaLevel = main?.seaLevel ?: 0
    val temp = main?.temp ?: 0.0
    val tempMax = main?.tempMax ?: 0.0
    val tempMin = main?.tempMin ?: 0.0

    val country = sys?.country ?: ""
    val countryId = sys?.id ?: 0
    val sunrise = sys?.sunrise ?: 0
    val sunset = sys?.sunset ?: 0
    val type = sys?.type ?: 0

    val timezone = timezone ?: 0
    val visibility = visibility ?: 0

    val description = weather?.first()?.description ?: ""
    val icon = weather?.first()?.icon ?: ""
    val weatherId = weather?.first()?.id ?: 0
    val main = weather?.first()?.main ?: ""

    val deg = wind?.deg ?: 0
    val gust = wind?.gust ?: 0.0
    val speed = wind?.speed ?: 0.0

    return WeatherByCityModel(
        base, all, cod,
        lat, lon, dt, id, feelsLike, grndLevel, humidity,
        pressure, seaLevel, temp, tempMax, tempMin, country,
        countryId, sunrise, sunset, type, timezone, visibility, description,
        icon, weatherId, main, deg, gust, speed
    )
}

fun WeatherByCityModel.toEntity() : CityEntity {

    return CityEntity(
        base, all, cod,
        lat, lon, dt, id, feelsLike, grndLevel, humidity,
        pressure, seaLevel, temp, tempMax, tempMin, country,
        countryId, sunrise, sunset, type, timezone, visibility, description,
        icon, weatherId, main, deg, gust, speed
    )

}
