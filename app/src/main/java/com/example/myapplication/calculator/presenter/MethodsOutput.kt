package com.example.myapplication.calculator.presenter

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView

class MethodsOutput : SecondaryMethods(), OutputInterface {

    override fun numPressed(button: Button, text: TextView, number: String): Unit =
        button.setOnClickListener {
            when {
                number != "0" -> editText(number, text)
                number == "0" -> if (!string.endsWith("/") && string.length != 0)
                    editText(number, text)
            }
        }

    override fun actionPressed(button: Button, text: TextView, string: String): Unit =
        button.setOnClickListener {
            if (actionAudit()) {
                editText(string, text)
                action = string
            }
        }

    override fun deleteAll(button: Button, text: TextView) {
        button.setOnClickListener {
            string = ""
            text.text = ""
            action = ""
        }
    }

    override fun deleteOne(button: ImageButton, text: TextView): Unit = button.setOnClickListener {
        if (string.isNotEmpty()) {
            string = string.dropLast(1)
            text.text = string
        }
    }

    override fun equal(button: Button, text: TextView, history: TextView, scrollView: ScrollView):
            Unit = button.setOnClickListener {
        if (equalAudit()) {
            addTextView(string, history)
            text.text = result()
            scrollView.fullScroll(View.FOCUS_DOWN)
            string = ""
            action = ""
        }
    }

    override fun coma(button: Button, text: TextView): Unit = button.setOnClickListener {
        if (string.isNotEmpty())
            editText(",", text)
    }

    override fun sinCos(button: Button, text: TextView, string: String):
            Unit = button.setOnClickListener {
                if (this.string.isEmpty()) {
                editText(string, text)
                action = string
        }
    }
}