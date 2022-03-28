package com.example.myapplication.calculator.presenter.action

import com.example.myapplication.calculator.presenter.Calculation
import kotlin.math.cos

class ActionCos: Calculation {
    override fun solution(value: Double, value1: Double): String {
        return String.format("%.2f", cos(value))
    }
}