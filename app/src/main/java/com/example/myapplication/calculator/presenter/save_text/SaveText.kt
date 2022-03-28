package com.example.myapplication.calculator.presenter.save_text

import android.content.Context
import android.content.SharedPreferences
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

abstract class SaveText : SaveTextModel() {

    fun saveText(history: TextView, requireActivity: FragmentActivity) {
        sPref = requireActivity.getSharedPreferences("MyApplication", Context.MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sPref.edit()
        ed.putString(savedText, history.text.toString())
        ed.apply()
    }

    fun loadText(history: TextView, requireActivity: FragmentActivity) {
        sPref = requireActivity.getSharedPreferences("MyApplication", Context.MODE_PRIVATE)
        val savedText: String = sPref.getString(savedText, "").toString()
        history.text = savedText
    }
}