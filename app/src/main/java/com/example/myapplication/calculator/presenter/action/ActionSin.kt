package com.example.myapplication.calculator.presenter.action

import com.example.myapplication.calculator.presenter.Calculation
import kotlin.math.sin

class ActionSin: Calculation {
    override fun solution(value: Double, value1: Double): String {
        return " = " + String.format("%.2f", sin(value))
    }
}
