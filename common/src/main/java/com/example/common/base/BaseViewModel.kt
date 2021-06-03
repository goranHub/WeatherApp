package com.example.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.common.utils.Event
import com.example.navigation.NavCommand

abstract class BaseViewModel: ViewModel() {

    protected val _snackbarError = MutableLiveData<Event<Int>>()
    val snackBarError: LiveData<Event<Int>> get() = _snackbarError

    private val _navigation = MutableLiveData<Event<NavCommand>>()
    val navigation: LiveData<Event<NavCommand>> = _navigation

     fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavCommand.To(directions))
    }
}