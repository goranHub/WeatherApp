package com.example.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    fun searchByCity(
        @Query("q") q: String,
        @Query("appid") appId: String = "5404e402bb177a821b6d24975ef60694"
    ) : Observable<com.example.model.response.ResponseByCity>


    @GET("data/2.5/weather")
    fun searchByLatLon(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String = "5404e402bb177a821b6d24975ef60694"
    ) : Observable<com.example.model.response.ResponseByCity>

}
