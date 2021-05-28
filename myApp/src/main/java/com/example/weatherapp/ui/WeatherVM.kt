package com.example.weatherapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.networking.WeatherAPi
import com.example.weatherapp.domain.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * @author lllhr
 * @date 5/28/2021
 */
class WeatherVM(val repository: Repository) : ViewModel() {


    private val observableCityEntity = WeatherAPi.searchByCity("zagreb")


    fun subscribeOnCurrentWeatherByCityNameFromApiAndSaveItIntoDb(disposable : CompositeDisposable)  {
        disposable.add(
            observableCityEntity
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        repository.weatherDao.insertCityWeather(it)
                    },
                    { error ->
                        Log.e(TAG, "Unable to get CityWeather ", error)
                    }
                )
        )
    }

    companion object {
        private val TAG = WeatherVM::class.java.simpleName
    }
}

