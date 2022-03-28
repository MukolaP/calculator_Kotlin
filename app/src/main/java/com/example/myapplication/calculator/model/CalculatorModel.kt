package com.example.myapplication.calculator.model

import com.example.myapplication.calculator.presenter.Context

open class CalculatorModel {
    var string: String = ""
    var action: String = ""

    var value: Double? = null
    var value1: Double? = null

    var context: Context = Context()
}