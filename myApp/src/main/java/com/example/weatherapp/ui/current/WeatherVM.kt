package com.example.weatherapp.ui.current

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.networking.WeatherAPi
import com.example.weatherapp.di.Injection
import com.example.weatherapp.domain.BindLocation
import com.example.weatherapp.domain.Repository
import com.example.weatherapp.domain.toEntity
import com.example.weatherapp.domain.toModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author lllhr
 * @date 5/28/2021
 */
class WeatherVM(private val repository: Repository,
                private val bindLocation: BindLocation,
                private val adapter: WeatherAdapter,
                ) : ViewModel() {


    var longi = bindLocation.longi
    var lati = bindLocation.lati


    fun subscribeOnCurrentWeatherByCityNameFromApiAndSaveItIntoDb(disposable : CompositeDisposable)  {
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
    }




    fun subscribeOnCurrentWeatherByLocationFromApiAndSaveItIntoDb(disposable : CompositeDisposable)  {
        disposable.add(
            repository.searchByCurrentLocation(lati, longi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        //add to DB
                        //repository.weatherDao.insertCityWeather(it.toModel().toEntity())
                        //add to adapter
                        adapter.add(it.weather)
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

