package com.example.wheatherapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.wheatherapp.data.database.CityEntity
import com.example.wheatherapp.data.database.WeatherDatabase
import com.example.wheatherapp.data.networking.WeatherAPi
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author lllhr
 * @date 5/28/2021
 */
class WeatherVM(val db : WeatherDatabase) : ViewModel() {


    private val observableCityEntity = WeatherAPi.searchByCity("zagreb")


    init {
        subscribeOnCurrentWeatherByCityNameFromApiAndSaveItIntoDb()
    }


    private fun subscribeOnCurrentWeatherByCityNameFromApiAndSaveItIntoDb() {
        observableCityEntity
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : Observer<CityEntity> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(it: CityEntity) {
                        db.weatherDao().insertCityWeather(it)
                    }

                    override fun onError(e: Throwable) {
                        Log.d("error", e.localizedMessage)
                    }

                    override fun onComplete() {
                    }
                }
            )
    }


}

