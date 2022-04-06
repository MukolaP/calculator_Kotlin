package com.example.myapplication.calculator.presenter

import android.widget.ScrollView
import android.widget.TextView

class DataOutput : MethodsOutput.Base(), OutputInterface {

    override fun pressed(text: TextView, history: TextView, scrollView: ScrollView, index: Int) {
        when (index) {
            0 -> zeroPressed(text)
            1, 2, 3, 4, 5, 6, 7, 8, 9 -> numPressed(index, text)
            10 -> actionPressed("+", text)
            11 -> actionPressed("-", text)
            12 -> actionPressed("*", text)
            13 -> actionPressed("/", text)
            14 -> actionPressed("%", text)
            15 -> sinCosPressed("sin (", text)
            16 -> sinCosPressed("cos (", text)
            17 -> deleteAllPressed(text)
            18 -> deleteOnePressed(text)
            19 -> comaPressed(text)
            20 -> equalPressed(text, history, scrollView)
        }
    }
}