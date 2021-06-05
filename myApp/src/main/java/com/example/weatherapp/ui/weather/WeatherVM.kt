package com.example.weatherapp.ui.weather

import android.location.Location
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.Repository
import com.example.weatherapp.domain.toEntity
import com.example.weatherapp.domain.toModel
import com.example.weatherapp.ui.current.BindResponse
import com.example.weatherapp.ui.current.ByLocationAdapter
import com.example.weatherapp.ui.search.BindByIdResponse
import com.example.weatherapp.ui.search.DayAdapter
import com.example.weatherapp.ui.search.HourAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 * @author lllhr
 * @date 5/28/2021
 */

private val TAG = WeatherVM::class.java.simpleName

class WeatherVM @ViewModelInject constructor(
    private val repository: Repository,
    val byLocationAdapter: ByLocationAdapter,
    val hourAdapter: HourAdapter,
    val dayAdapter: DayAdapter
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

    }*/

    fun byLocation(location: Location, disposable: CompositeDisposable) {
        disposable.add(
            repository.searchByCurrentLocation(location.latitude, location.longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { responseByCity ->
                        //add to DB
                        repository.insertCityWeather(responseByCity.toModel().toEntity())
                        //add to adapter
                        val bindResponseByCity = BindResponse(responseByCity)
                        byLocationAdapter.add(bindResponseByCity)
                    },
                    { error ->
                        Log.e(TAG, "searchByCurrentLocation", error)
                    }
                )
        )
    }


    fun byCityName(name: String, disposable: CompositeDisposable) {
        disposable.add(
            repository.searchByCity(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        it.id?.let { it1 -> byId(it1, disposable) }
                    },
                    { error ->
                        Log.e(TAG, "searchByCity", error)
                    }
                )
        )
    }

    fun byId(id :Int, disposable: CompositeDisposable){
        disposable.add(
            repository.searchWithID(id.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        val bindResponseByCity = BindByIdResponse(it)
                        hourAdapter.add(bindResponseByCity)
                        //dayAdapter.add(bindResponseByCity)
                    },
                    { error ->
                        Log.e(TAG, "searchWithID", error)
                    }
                )
        )
    }


}

