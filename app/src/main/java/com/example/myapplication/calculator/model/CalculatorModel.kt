package com.example.myapplication.calculator.model

import com.example.myapplication.calculator.presenter.Context

data class CalculatorModel(
    var string: String = "",
    var action: String = "",
    var value: Double = 0.0,
    var value1: Double = 0.0,
    val context: Context = Context()
)