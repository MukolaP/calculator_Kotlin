package com.example.myapplication.calculator.presenter

import kotlin.math.cos
import kotlin.math.sin

interface Calculation {

    fun solution(value: Double, value1: Double): String

    class ActionPlus: Calculation {
        override fun solution(value: Double, value1: Double): String {
            return (value + value1).toString()
        }
    }

    class ActionMinus : Calculation {
        override fun solution(value: Double, value1: Double): String {
            return (value - value1).toString()
        }
    }

    class ActionMultiplication : Calculation {
        override fun solution(value: Double, value1: Double): String {
            return (value * value1).toString()
        }
    }

    class ActionDivision : Calculation {
        override fun solution(value: Double, value1: Double): String {
            return (value / value1).toString()
        }
    }

    class ActionPerSent : Calculation {
        override fun solution(value: Double, value1: Double): String {
            return (value % value1).toString()
        }
    }

    class ActionSin: Calculation {
        override fun solution(value: Double, value1: Double): String {
            return " = " + String.format("%.2f", sin(value))
        }
    }

    class ActionCos: Calculation {
        override fun solution(value: Double, value1: Double): String {
            return String.format("%.2f", cos(value))
        }
    }

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