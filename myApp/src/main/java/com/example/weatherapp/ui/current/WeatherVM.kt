package com.example.weatherapp.ui.current

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.database.MyLocationEntity
import com.example.weatherapp.domain.Repository
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author lllhr
 * @date 5/28/2021
 */

class WeatherVM @ViewModelInject constructor(
    private val repository: Repository,
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


/*    fun byLocation(disposable : CompositeDisposable)  {
        disposable.add(
            repository.searchByCurrentLocation(lati, longi)
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


    fun locationListFromDB() {
        repository
            .getLocations()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<MyLocationEntity>> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(locations: List<MyLocationEntity>) {
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


    fun startLocationUpdates() = repository.startLocationUpdates()

    fun stopLocationUpdates() = repository.stopLocationUpdates()

    companion object {
        private val TAG = WeatherVM::class.java.simpleName
    }
}

