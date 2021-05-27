package com.example.wheatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.wheatherapp.database.CityEntity
import com.example.wheatherapp.database.WeatherRoomDatabase
import com.example.wheatherapp.networking.WeatherAPi
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val disposables = CompositeDisposable()

        // test to load in Db from api call

        val db = WeatherRoomDatabase.fetchDatabase(this)

        val singleCityEntity = WeatherAPi.searchByCity("zagreb")


        singleCityEntity
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toObservable()
            .subscribe{
                db.weatherDao().insertCityWheather(it)
            }

/*        singleCityEntity
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(
                object : SingleObserver<CityEntity>{
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onSuccess(it: CityEntity) {
                        Log.d(this@MainActivity::class.java.name, it.base)
                        db.weatherDao().insertCityWheather(it)
                    }

                    override fun onError(e: Throwable) {
                        Log.d(this@MainActivity::class.java.name, e.localizedMessage)
                    }

                }
            )*/
    }
}