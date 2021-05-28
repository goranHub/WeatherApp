package com.example.wheatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wheatherapp.data.database.WeatherRoomDatabase
import com.example.wheatherapp.data.networking.WeatherAPi
import com.example.wheatherapp.ui.WeatherVM
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = WeatherRoomDatabase.fetchDatabase(this)
        WeatherVM(db)

    }
}