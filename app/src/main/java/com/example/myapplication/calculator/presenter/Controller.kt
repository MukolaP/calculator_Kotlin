package com.example.myapplication.calculator.presenter

import com.example.myapplication.calculator.model.CalculatorModel

interface Controller {

    fun result(): String

    fun resultToEqual()

    fun radiusEqual()

    open class Base: CalculatorModel(), Controller {

        override fun result(): String {
            string = string.replace(",", ".")

            if (action != "sin (" && action != "cos (") {
                resultToEqual()
            } else radiusEqual()

            if (action == "+") context.setCalculation(Calculation.ActionPlus())
            if (action == "-") context.setCalculation(Calculation.ActionMinus())
            if (action == "*") context.setCalculation(Calculation.ActionMultiplication())
            if (action == "/") context.setCalculation(Calculation.ActionDivision())
            if (action == "%") context.setCalculation(Calculation.ActionPerSent())
            if (action == "sin (") context.setCalculation(Calculation.ActionSin())
            if (action == "cos (") context.setCalculation(Calculation.ActionCos())

            return context.executeStrategy(value, value1).replace(".", ",")
        }

        override fun resultToEqual() {
                val paradigm = string.split(action, limit = 2)
                value = paradigm[0].toDouble()
                value1 = paradigm[1].toDouble()
        }

        override fun radiusEqual() {
            value = string.substring(5).toDouble()
        }
    }
}