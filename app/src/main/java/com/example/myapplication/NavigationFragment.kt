package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentNavigationBinding
import com.example.myapplication.navigate.navigate


class NavigationFragment : BaseFragment<FragmentNavigationBinding>() {

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNavigationBinding =
        FragmentNavigationBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigateCalculator.setOnClickListener { navigate().goToCalculator() }
    }
}