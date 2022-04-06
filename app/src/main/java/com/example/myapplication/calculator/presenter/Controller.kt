package com.example.myapplication.calculator.presenter

import com.example.myapplication.calculator.model.CalculatorModel

interface Controller {

    fun result(): String

    fun lineOnParts()

    fun splitStroke()

    fun splitStrokeSin()

    open class Base : Controller {

        val calculatorModel: CalculatorModel

        constructor(calculatorModel: CalculatorModel) {
            this.calculatorModel = calculatorModel
        }

        override fun result(): String {
            with(calculatorModel) {
                lineOnParts()

                if (action == "+") context.setCalculation(Calculation.ActionPlus())
                if (action == "-") context.setCalculation(Calculation.ActionMinus())
                if (action == "*") context.setCalculation(Calculation.ActionMultiplication())
                if (action == "/") context.setCalculation(Calculation.ActionDivision())
                if (action == "%") context.setCalculation(Calculation.ActionPerSent())
                if (action == "sin (") context.setCalculation(Calculation.ActionSin())
                if (action == "cos (") context.setCalculation(Calculation.ActionCos())

                return context.executeStrategy(value, value1).replace(".", ",")
            }
        }

        override fun lineOnParts() {
            calculatorModel.string = calculatorModel.string.replace(",", ".")

            if (calculatorModel.action != "sin (" && calculatorModel.action != "cos (") {
                splitStroke()
            } else splitStrokeSin()
        }

        override fun splitStroke() {
            val paradigm = calculatorModel.string.split(calculatorModel.action, limit = 2)
            calculatorModel.value = paradigm[0].toDouble()
            calculatorModel.value1 = paradigm[1].toDouble()
        }

        override fun splitStrokeSin() {
            calculatorModel.value = calculatorModel.string.substring(5).toDouble()
        }
    }
}