package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), ButtonFragment.CalcButtonsListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun entry(text: String) {
        val calcDisplayFragment = supportFragmentManager.findFragmentById(R.id.calcDisplayFragment) as DisplayFragment
        calcDisplayFragment.changeDisplayText(text)
    }

    override fun root() {
        val calcDisplayFragment = supportFragmentManager.findFragmentById(R.id.calcDisplayFragment) as DisplayFragment
        calcDisplayFragment.calculateRoot()
    }

    override fun clear() {
        val calcDisplayFragment = supportFragmentManager.findFragmentById(R.id.calcDisplayFragment) as DisplayFragment
        calcDisplayFragment.clearText()
    }

    override fun equals() {
        val calcDisplayFragment = supportFragmentManager.findFragmentById(R.id.calcDisplayFragment) as DisplayFragment
        calcDisplayFragment.calculate()
    }


}