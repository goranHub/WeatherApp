package com.example.weatherapp.data.responseById

data class ResponseById(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ForecastList>,
    val message: Int
)