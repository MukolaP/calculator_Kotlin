package com.example.myapplication.navigate

import androidx.fragment.app.Fragment

fun Fragment.navigate(): Navigate {
    return requireActivity() as Navigate
}

interface Navigate {

    fun goMenu()

    fun goToCalculator()
}