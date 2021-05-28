package com.example.weatherapp.data.networking

import com.example.weatherapp.data.response.ResponseByCity
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWheatherService {

    companion object{
        fun create() : OpenWheatherService {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(WeatherAPi.API)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(OpenWheatherService::class.java)

        }
    }

    @GET("data/2.5/weather")
    fun searchByCity(
        @Query("q") q: String,
        @Query("appid") appId: String = "5404e402bb177a821b6d24975ef60694"
    ) : Observable<ResponseByCity>

}
