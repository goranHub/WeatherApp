package com.example.weatherapp.domain

import com.example.weatherapp.data.database.CityEntity
import com.example.weatherapp.data.model.ByLocationModel
import com.example.weatherapp.data.responseByLocation.ResponseByLocation

/**
 * @author lllhr
 * @date 5/28/2021
 */


fun ResponseByLocation.toModel(): ByLocationModel {

    val base = base ?: ""
    val all = clouds?.all ?: 0
    val cod = cod ?: 0

    val lat = coord?.lat.toString() ?: "0.0"
    val lon = coord?.lon.toString() ?: "0.0"

    val dt = dt ?: 0
    val id = id ?: 0

    val feelsLike = main?.feelsLike.toString() ?: "0.0"
    val grndLevel = main?.grndLevel.toString() ?: "0"
    val humidity = main?.humidity.toString() ?: "0"
    val pressure = main?.pressure.toString() ?: "0"
    val seaLevel = main?.seaLevel.toString() ?: "0"
    val temp = main?.temp.toString() ?: "0.0"
    val tempMax = main?.tempMax.toString() ?: "0.0"
    val tempMin = main?.tempMin.toString() ?: "0.0"

    val name = name ?: ""

    val country = sys?.country ?: ""
    val countryId = sys?.id.toString() ?: "0"
    val sunrise = sys?.sunrise.toString() ?: "0"
    val sunset = sys?.sunset.toString() ?: "0"
    val type = sys?.type.toString() ?: "0"

    val timezone = timezone.toString() ?: "0"
    val visibility = visibility.toString() ?: "0"

    val description = weather?.first()?.description ?: ""
    val icon = weather?.first()?.icon ?: ""
    val weatherId = weather?.first()?.id.toString() ?: "0"
    val main = weather?.first()?.main ?: ""

    val deg = wind?.deg.toString() ?: "0"
    val gust = wind?.gust.toString() ?: "0.0"
    val speed = wind?.speed.toString() ?: "0.0"

    return ByLocationModel(
        base, all, cod,
        lat, lon, dt, id, feelsLike, grndLevel, humidity,
        pressure, seaLevel, temp, tempMax, tempMin, name, country,
        countryId, sunrise, sunset, type, timezone, visibility, description,
        icon, weatherId, main, deg, gust, speed
    )
}

fun ByLocationModel.toEntity() : CityEntity {

    return CityEntity(
        base, all, cod,
        lat, lon, dt, id, feelsLike, grndLevel, humidity,
        pressure, seaLevel, temp, tempMax, tempMin, name, country,
        countryId, sunrise, sunset, type, timezone, visibility, description,
        icon, weatherId, main, deg, gust, speed
    )

}
