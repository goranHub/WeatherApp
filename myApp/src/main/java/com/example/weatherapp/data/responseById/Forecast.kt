package com.example.weatherapp.data.responseById

import com.google.gson.annotations.SerializedName

/**
 * @author lllhr
 * @date 6/4/2021
 */
data class Forecast(
    val clouds: Clouds,
    val dt: String,
    @SerializedName("dt_txt")
    var dtTxt: String,
    val main: Main,
    val pop: Double,
    val rain: Rain,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)