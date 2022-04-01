package com.example.myapplication.calculator.presenter

import android.widget.Button
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView

interface OutputInterface : Delete, Action {

    fun numPressed(button: Button, text: TextView, number: String)

    fun equal(button: Button, text: TextView, history: TextView, scrollView: ScrollView)

    fun coma(button: Button, text: TextView)
}

interface Delete {

    fun deleteAll(button: Button, text: TextView)

    fun deleteOne(button: ImageButton, text: TextView)
}

interface Action {

    fun actionPressed(button: Button, text: TextView, string: String)

    fun sinCos(button: Button, text: TextView, string: String)
}

interface SecondaryMethodsInt {

    fun editText(string: String, text: TextView)

    fun actionAudit(): Boolean

    fun equalAudit(): Boolean

    fun addTextView(string: String, history: TextView)
}

