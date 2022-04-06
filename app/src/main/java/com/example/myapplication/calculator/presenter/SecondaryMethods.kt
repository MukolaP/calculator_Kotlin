package com.example.myapplication.calculator.presenter

import android.annotation.SuppressLint
import android.widget.TextView
import com.example.myapplication.calculator.model.CalculatorModel

open class SecondaryMethods : Controller.Base(CalculatorModel()), SecondaryMethodsInt {

    override fun editText(string: String, text: TextView) {
        calculatorModel.string += string
        text.text = calculatorModel.string
    }

    override fun actionAudit(): Boolean {
        return calculatorModel.string.isNotEmpty() && calculatorModel.action.isEmpty()
    }

    override fun equalAudit(): Boolean {
        return calculatorModel.string.isNotEmpty() && calculatorModel.action.isNotEmpty() &&
                calculatorModel.string.substring(calculatorModel.string.length - 1) != calculatorModel.action
    }

    override fun addTextToHistory(string: String, history: TextView) {
        if (calculatorModel.action != "sin (" && calculatorModel.action != "cos (") {
            addTextToHistory(history, " = ")
        } else {
            addTextToHistory(history, ") ")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addTextToHistory(history: TextView, s: String) {
        history.text =
            """${history.text}${calculatorModel.string}${s + result()}""".trimIndent() + "\n"
    }
}