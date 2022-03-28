package com.example.myapplication.calculator.presenter

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView

class MethodsOutput : Controller() {

    fun numPressed(button: Button, text: TextView, number: String): Unit =
        button.setOnClickListener {
            when {
                number != "0" -> editText(number, text)
                number == "0" -> if (!string.endsWith("/") && string.length != 0)
                    editText(number, text)
            }
        }

    fun actionPressed(button: Button, text: TextView, string: String): Unit =
        button.setOnClickListener {
            if (string.isNotEmpty() && action.isEmpty()) {
                editText(string, text)
                action = string
            }
        }

    fun deleteAll(button: Button, text: TextView) {
        button.setOnClickListener {
            string = ""
            text.text = ""
            action = ""
        }
    }

    fun deleteOne(button: ImageButton, text: TextView): Unit = button.setOnClickListener {
        if (string.isNotEmpty()) {
            string = string.dropLast(1)
            text.text = string
        }
    }

    fun equal(button: Button, text: TextView, history: TextView, scrollView: ScrollView):
            Unit = button.setOnClickListener {
        if (equalAudit()) {
            addTextView(string, history)
            text.text = result()
            scrollView.fullScroll(View.FOCUS_DOWN)
            string = ""
            action = ""
        }
    }

    fun coma(button: Button, text: TextView): Unit = button.setOnClickListener {
        if (string.isNotEmpty())
            editText(",", text)
    }

    fun sinCos(button: Button, text: TextView, string: String): Unit = button.setOnClickListener {
        if (string.isEmpty()) {
            editText(string, text)
            action = string
        }
    }
}