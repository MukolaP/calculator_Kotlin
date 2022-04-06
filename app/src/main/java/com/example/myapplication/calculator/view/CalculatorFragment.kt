package com.example.myapplication.calculator.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.BaseFragment
import com.example.myapplication.calculator.presenter.DataOutput
import com.example.myapplication.calculator.presenter.save_text.SaveText
import com.example.myapplication.databinding.FragmentCalculatorBinding


class CalculatorFragment : BaseFragment<FragmentCalculatorBinding>() {
    private val dataOutput = DataOutput()
    private val saveText: SaveText = SaveText.Base()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentCalculatorBinding =
        FragmentCalculatorBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backCalculator.setOnClickListener { navigateToBack() }

        binding.paradigm.setMovementMethod(ScrollingMovementMethod())

        val numberIds = arrayOf(
            binding.numberZero,
            binding.numberOne,
            binding.numberTwo,
            binding.numberThree,
            binding.numberFour,
            binding.numberFive,
            binding.numberSix,
            binding.numberSeven,
            binding.numberEight,
            binding.numberNine,
            binding.actionPlus,
            binding.actionMinus,
            binding.actionMultiplication,
            binding.actionDivision,
            binding.actionPerCent,
            binding.actionSin,
            binding.actionCos,
            binding.deleteAll,
            binding.deleteOne,
            binding.coma,
            binding.equal
        )

        for (index in 0 until numberIds.size) {
            numberIds[index].setOnClickListener {
                dataOutput.pressed(
                    binding.paradigm, binding.history,
                    binding.SCROLLERID, index,
                )
            }
        }

        saveText.loadText(binding.history, requireActivity())
    }

    override fun onStop() {
        super.onStop()
        saveText.saveText(binding.history, requireActivity())
    }
}