package com.example.myapplication.calculator.presenter

import android.annotation.SuppressLint
import android.widget.TextView
import com.example.myapplication.calculator.model.CalculatorModel
import com.example.myapplication.calculator.presenter.action.*

abstract class Controller: CalculatorModel() {

    fun result(): String{
        string = string.replace(",", ".")
        resultToEqual()

        if (action == "+") { context.setCalculation(ActionPlus()) }
        if (action == "-") { context.setCalculation(ActionMinus()) }
        if (action == "*") { context.setCalculation(ActionMultiplication()) }
        if (action == "/") { context.setCalculation(ActionDivision()) }
        if (action == "%") { context.setCalculation(ActionPerSent()) }
        if (action == "sin (") { context.setCalculation(ActionSin()) }
        if (action == "cos (") { context.setCalculation(ActionCos()) }

        return context.executeStrategy(value!!, value1!!).replace(".",",")
    }

    private fun resultToEqual() {
        if (action != "sin (" && action != "cos (") {
            val paradigm = string.split(action, limit = 2)
            value = paradigm[0].toDouble()
            value1 = paradigm[1].toDouble()
        }
        else radiusEqual()
    }

    private fun radiusEqual(){
        value = string.substring(5).toDouble()
        value1 = 0.0
    }

    fun editText(string: String, text: TextView) {
        this.string += string
        text.text = this.string
    }

    fun equalAudit(): Boolean {
        return string.isNotEmpty() && action.isNotEmpty() &&
                string.substring(string.length - 1) != action
    }

    @SuppressLint("SetTextI18n")
    fun addTextView(string: String, history: TextView) {
        if (action != "sin (" && action != "cos (") {
            history.text = """${history.text}${string}${" = " + result()}""".trimIndent() + "\n"
        }
        else{
            history.text = """${history.text}${string}${") " + result()}""".trimIndent() + "\n"
        }
    }
}