package com.example.current

import android.location.Location
import android.util.Log
import androidx.lifecycle.ViewModel


/**
 * @author lllhr
 * @date 5/28/2021
 */

private val TAG = WeatherVM::class.java.simpleName

class WeatherVM @ViewModelInject constructor(
    private val repository: com.example.repository.Repository,
    val adapter: WeatherAdapter
) : ViewModel() {


/*    fun byName(disposable: CompositeDisposable) {
        disposable.add(
            repository.observableCityEntity("zagreb")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        //add to DB
                        repository.weatherDao.insertCityWeather(it.toModel().toEntity())
                        //add to adapter
                        adapter.add(it.weather)
                    },
                    { error ->
                        Log.e(TAG, "Unable to get CityWeather ", error)
                    }
                )
        )
    }*/


    fun byLocation(location : Location, disposable : CompositeDisposable) {
        disposable.add(
            repository.searchByCurrentLocation(location.latitude, location.longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        //add to DB
                        repository.insertCityWeather(it.toModel().toEntity())
                        //add to adapter
                        adapter.add(it.weather)
                    },
                    { error ->
                        Log.e(TAG, "Unable to get CityWeather ", error)
                    }
                )
        )
    }


    fun locationListFromDB() {
        repository
            .getLocations()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<com.example.local.database.MyLocationEntity>> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(locations: List<com.example.local.database.MyLocationEntity>) {
                    for (location in locations) {
                        Log.d(TAG, location.latitude.toString())
                    }
                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }
            })
    }





}

