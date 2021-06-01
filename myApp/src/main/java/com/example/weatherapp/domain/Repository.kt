package com.example.weatherapp.domain

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import com.example.weatherapp.data.database.MyLocationEntity
import com.example.weatherapp.data.database.WeatherDao
import com.example.weatherapp.data.networking.NetworkDataSource
import com.example.weatherapp.data.response.ResponseByCity
import io.reactivex.Observable
import java.util.concurrent.Executors

/**
 * @author lllhr
 * @date 5/28/2021
 */
class Repository (
    private val  weatherDao: WeatherDao,
    private val weatherApi : NetworkDataSource,
    private val myLocationManager: MyLocationManager
) {

    private val executor = Executors.newSingleThreadExecutor()

    fun searchByCurrentLocation(lat : Double, long: Double): Observable<ResponseByCity> {
        return weatherApi.searchByCurrentLocation(lat, long)
    }

    fun observableCityEntity(name : String): Observable<ResponseByCity> {
        return weatherApi.searchByCity(name)
    }

    fun getLocations() = weatherDao.getLocations()

    //fun getLocation(id: UUID) = weatherDao.getLocation(id)

    fun updateLocation(myLocationEntity: MyLocationEntity) {
        executor.execute {
            weatherDao.updateLocation(myLocationEntity)
        }
    }

    fun addLocation(myLocationEntity: MyLocationEntity) {
        executor.execute {
            weatherDao.addLocation(myLocationEntity)
        }
    }

    fun addLocations(myLocationEntities: List<MyLocationEntity>) {
        executor.execute {
            weatherDao.addLocations(myLocationEntities)
        }
    }


    val receivingLocationUpdates: LiveData<Boolean> = myLocationManager.receivingLocationUpdates

    @MainThread
    fun startLocationUpdates() = myLocationManager.startLocationUpdates()

    @MainThread
    fun stopLocationUpdates() = myLocationManager.stopLocationUpdates()


}