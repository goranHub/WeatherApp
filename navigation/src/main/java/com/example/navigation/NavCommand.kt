package com.example.navigation
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections

/**
 * A simple sealed class to handle more properly
 * navigation from a [ViewModel]
 */
sealed class NavCommand {
    data class To(val directions: NavDirections): NavCommand()
    object Back: NavCommand()
}