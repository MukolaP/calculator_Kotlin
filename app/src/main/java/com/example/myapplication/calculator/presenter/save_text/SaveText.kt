package com.example.myapplication.calculator.presenter.save_text

import android.content.Context
import android.content.SharedPreferences
import android.widget.TextView

interface SaveText {

    fun saveText(history: TextView, context: Context)

    fun loadText(history: TextView, context: Context)

    fun getSharedPrefers(context: Context): SharedPreferences

    class Base : SaveText{

        private lateinit var sPref: SharedPreferences
        private val savedText: String = "saved_text"
        private val name: String = "MyApplication"

        override fun saveText(history: TextView, context: Context) {
            sPref = getSharedPrefers(context)
            val ed: SharedPreferences.Editor = sPref.edit()
            ed.putString(savedText, history.text.toString())
            ed.apply()
        }

        override fun loadText(history: TextView, context: Context) {
            sPref = getSharedPrefers(context)
            val savedText: String = sPref.getString(savedText, "").toString()
            history.text = savedText
        }

        override fun getSharedPrefers(context: Context): SharedPreferences {
            return context.getSharedPreferences(name, Context.MODE_PRIVATE)
        }
    }
}