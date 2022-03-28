package com.example.myapplication.calculator.presenter

interface Calculation {
    fun solution(value: Double, value1: Double): String

}

class Context {
    private lateinit var calculation: Calculation

    fun setCalculation(calculation: Calculation) {
        this.calculation = calculation
    }

    fun executeStrategy(value: Double, value1: Double): String {
        return calculation.solution(value, value1)
    }
}