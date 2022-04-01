package com.example.myapplication.calculator.presenter

import android.annotation.SuppressLint
import android.widget.TextView

open class SecondaryMethods : Controller.Base(), SecondaryMethodsInt {

    override fun editText(string: String, text: TextView) {
        this.string += string
        text.text = this.string
    }

    override fun actionAudit(): Boolean {
        return string.isNotEmpty() && action.isEmpty()
    }

    override fun equalAudit(): Boolean {
        return string.isNotEmpty() && action.isNotEmpty() &&
                string.substring(string.length - 1) != action
    }

    override fun addTextView(string: String, history: TextView) {
        if (action != "sin (" && action != "cos (") {
            addTextView(history, " = ")
        } else {
            addTextView(history, ") ")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addTextView(history: TextView, s: String) {
        history.text = """${history.text}${string}${s + result()}""".trimIndent() + "\n"
    }
}