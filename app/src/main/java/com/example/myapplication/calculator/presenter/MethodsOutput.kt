package com.example.myapplication.calculator.presenter

import android.view.View
import android.widget.ScrollView
import android.widget.TextView

interface MethodsOutput {

    fun zeroPressed(text: TextView)

    fun numPressed(index: Int, text: TextView)

    fun actionPressed(name: String, text: TextView)

    fun sinCosPressed(name: String, text: TextView)

    fun deleteAllPressed(text: TextView)

    fun deleteOnePressed(text: TextView)

    fun comaPressed(text: TextView)

    fun equalPressed(text: TextView, history: TextView, scrollView: ScrollView)

    open class Base : SecondaryMethods(), MethodsOutput {

        override fun zeroPressed(text: TextView) {
            if (!calculatorModel.string.endsWith("/") && calculatorModel.string.length != 0) {
                editText("0", text)
            }
        }

        override fun numPressed(index: Int, text: TextView) {
            editText(index.toString(), text)
        }

        override fun actionPressed(name: String, text: TextView) {
            if (actionAudit()) {
                editText(name, text)
                calculatorModel.action = name
            }
        }

        override fun sinCosPressed(name: String, text: TextView) {
            if (calculatorModel.string.isEmpty()) {
                editText(name, text)
                calculatorModel.action = name
            }
        }

        override fun deleteAllPressed(text: TextView) {
            calculatorModel.string = ""
            text.text = ""
            calculatorModel.action = ""
        }

        override fun deleteOnePressed(text: TextView) {
            if (calculatorModel.string.isNotEmpty()) {
                calculatorModel.string = calculatorModel.string.dropLast(1)
                text.text = calculatorModel.string
            }
        }

        override fun comaPressed(text: TextView) {
            if (calculatorModel.string.isNotEmpty())
                editText(",", text)
        }

        override fun equalPressed(text: TextView, history: TextView, scrollView: ScrollView) {
            if (equalAudit()) {
                addTextToHistory(calculatorModel.string, history)
                text.text = result()
                scrollView.fullScroll(View.FOCUS_DOWN)
                calculatorModel.string = ""
                calculatorModel.action = ""
            }
        }
    }
}