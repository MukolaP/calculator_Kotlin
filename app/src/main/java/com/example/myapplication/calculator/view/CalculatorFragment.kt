package com.example.myapplication.calculator.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.BaseFragment
import com.example.myapplication.R
import com.example.myapplication.calculator.presenter.MethodsOutput
import com.example.myapplication.databinding.FragmentCalculatorBinding


class CalculatorFragment : BaseFragment<FragmentCalculatorBinding>() {
    private val calculatorView = MethodsOutput()
    private lateinit var history: TextView
    lateinit var sPref: SharedPreferences
    val savedText: String = "saved_text"

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentCalculatorBinding =
        FragmentCalculatorBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        history = view.findViewById(R.id.history)

        binding.backCalculator.setOnClickListener { navigateToBack() }

        binding.paradigm.setMovementMethod(ScrollingMovementMethod())

        with(calculatorView) {
            numPressed(binding.numberZero, binding.paradigm, "0")
            numPressed(binding.numberOne, binding.paradigm, "1")
            numPressed(binding.numberTwo, binding.paradigm, "2")
            numPressed(binding.numberThree, binding.paradigm, "3")
            numPressed(binding.numberFour, binding.paradigm, "4")
            numPressed(binding.numberFive, binding.paradigm, "5")
            numPressed(binding.numberSix, binding.paradigm, "6")
            numPressed(binding.numberSeven, binding.paradigm, "7")
            numPressed(binding.numberEight, binding.paradigm, "8")
            numPressed(binding.numberNine, binding.paradigm, "9")

            coma(binding.coma, binding.paradigm)

            actionPressed(binding.actionPlus, binding.paradigm, "+")
            actionPressed(binding.actionMinus, binding.paradigm, "-")
            actionPressed(binding.actionMultiplication, binding.paradigm, "*")
            actionPressed(binding.actionDivision, binding.paradigm, "/")
            actionPressed(binding.actionPerCent, binding.paradigm, "%")

            sinCos(binding.actionSin, binding.paradigm, "sin (")
            sinCos(binding.actionCos, binding.paradigm, "cos (")

            deleteAll(binding.deleteAll, binding.paradigm)
            deleteOne(binding.deleteOne, binding.paradigm)

            equal(binding.equal, binding.paradigm, binding.history, binding.SCROLLERID)
        }
        loadText(history)
    }

    override fun onDestroy() {
        super.onDestroy()
        saveText(history)
    }

    fun saveText(history: TextView) {
        sPref = requireActivity().getSharedPreferences("MyApplication", Context.MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sPref.edit()
        ed.putString(savedText, history.text.toString())
        ed.apply()
    }

    fun loadText(history: TextView) {
        sPref = requireActivity().getSharedPreferences("MyApplication", Context.MODE_PRIVATE)
        val savedText: String = sPref.getString(savedText, "").toString()
        history.text = savedText
    }
}