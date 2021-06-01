package com.example.local.database

import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author lllhr
 * @date 6/1/2021
 */
class DatabaseSource @Inject constructor(
    private val weatherDao: WeatherDao
) {

    fun insertCityWeather(city: CityEntity): Completable {
        return weatherDao.insertCityWeather(city)
    }

    fun addLocations(myLocationEntities: List<MyLocationEntity>) {
        return weatherDao.addLocations(myLocationEntities)
    }

    fun addLocation(myLocationEntity: MyLocationEntity) {
        return weatherDao.addLocation(myLocationEntity)

    }

    fun updateLocation(myLocationEntity: MyLocationEntity) {
        return weatherDao.updateLocation(myLocationEntity)
    }

    fun getLocations(): Observable<List<MyLocationEntity>> {
        return weatherDao.getLocations()
    }


}