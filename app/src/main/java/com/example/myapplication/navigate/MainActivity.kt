package com.example.myapplication.navigate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.NavigationFragment
import com.example.myapplication.R
import com.example.myapplication.calculator.view.CalculatorFragment

class MainActivity : AppCompatActivity(), Navigate{
    private val navigationFragment = NavigationFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.MainActivity, navigationFragment)
            .commit()
    }

    override fun goMenu() {
        launchFragment(NavigationFragment())
    }

    override fun goToCalculator() {
        launchFragment(CalculatorFragment())
    }

    private fun launchFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.MainActivity, fragment)
            .commit()
    }
}
