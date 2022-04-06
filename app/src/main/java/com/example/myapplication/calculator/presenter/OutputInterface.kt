package com.example.myapplication.calculator.presenter

import android.widget.ScrollView
import android.widget.TextView

interface OutputInterface {

    fun pressed(text: TextView, history: TextView, scrollView: ScrollView, index: Int)
}

interface SecondaryMethodsInt {

    fun editText(string: String, text: TextView)

    fun actionAudit(): Boolean

    fun equalAudit(): Boolean

    fun addTextToHistory(string: String, history: TextView)
}

