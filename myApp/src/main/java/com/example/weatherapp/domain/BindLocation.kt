package com.example.weatherapp.domain

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlin.properties.Delegates
import com.example.weatherapp.BR

/**
 * @author lllhr
 * @date 5/28/2021
 */
class BindLocation() : BaseObservable() {


    @get:Bindable
    var lati by Delegates.observable(0.0) { _, _, _ -> notifyPropertyChanged(BR.lati) }

    @get:Bindable
    var longi  by Delegates.observable(0.0) { _, _, _ -> notifyPropertyChanged(BR.longi) }

}

