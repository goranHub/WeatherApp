package com.example.weatherapp.data.responseById

/**
 * @author lllhr
 * @date 6/4/2021
 */
class ForecastList(
    val clouds: Clouds,
    val dt: Int,
    var dt_txt: String,
    val main: Main,
    val pop: Double,
    val rain: Rain,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)