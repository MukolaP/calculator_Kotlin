package com.example.myapplication.calculator.presenter.action

import com.example.myapplication.calculator.presenter.Calculation

class ActionMultiplication : Calculation {
    override fun solution(value: Double, value1: Double): String {
        return (value * value1).toString()
    }
}