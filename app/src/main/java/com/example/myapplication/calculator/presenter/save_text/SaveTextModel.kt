package com.example.myapplication.calculator.presenter.save_text

import android.content.SharedPreferences

abstract class SaveTextModel {
    lateinit var sPref: SharedPreferences
    val savedText: String = "saved_text"
 }