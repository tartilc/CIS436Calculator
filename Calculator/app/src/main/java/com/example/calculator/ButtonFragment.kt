package com.example.calculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculator.databinding.ButtonPadBinding

class ButtonFragment : Fragment() {
    private lateinit var  binding : ButtonPadBinding

    var activityCallback : ButtonFragment.CalcButtonsListener? = null

    interface CalcButtonsListener {
        fun entry(text: String)
        fun clear()
        fun equals()
        fun root()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ButtonPadBinding.inflate(inflater, container, false)

        binding.btnDivide.setOnClickListener{v: View -> numBtnClicked(v, "/")}
        binding.btnMultiply.setOnClickListener{v: View -> numBtnClicked(v, "*")}
        binding.btnMinus.setOnClickListener{v: View -> numBtnClicked(v, "-")}
        binding.btnPlus.setOnClickListener{v: View -> numBtnClicked(v, "+")}
        binding.btnMod.setOnClickListener{v: View -> numBtnClicked(v, "%")}
        binding.btnPosneg.setOnClickListener{v: View -> numBtnClicked(v, "-")}
        binding.btnDecimal.setOnClickListener{v: View -> numBtnClicked(v, ".")}

        binding.btn0.setOnClickListener{ v: View -> numBtnClicked(v, "0")}
        binding.btn1.setOnClickListener{ v: View -> numBtnClicked(v, "1")}
        binding.btn2.setOnClickListener{ v: View -> numBtnClicked(v, "2")}
        binding.btn3.setOnClickListener{ v: View -> numBtnClicked(v, "3")}
        binding.btn4.setOnClickListener{ v: View -> numBtnClicked(v,"4")}
        binding.btn5.setOnClickListener{ v: View -> numBtnClicked(v, "5")}
        binding.btn6.setOnClickListener{v: View -> numBtnClicked(v, "6")}
        binding.btn7.setOnClickListener{v: View -> numBtnClicked(v, "7")}
        binding.btn8.setOnClickListener{v: View -> numBtnClicked(v, "8")}
        binding.btn9.setOnClickListener{v: View -> numBtnClicked(v, "9")}

        binding.btnRoot.setOnClickListener{v: View -> rootBtnClicked(v)}
        binding.btnClear.setOnClickListener{v: View -> clearBtnClicked(v)}
        binding.btnEquals.setOnClickListener{v: View -> equalsBtnClicked(v)}

        return binding.root
    }

    override fun onAttach(context : Context) {
        super.onAttach(context)
        activityCallback = context as CalcButtonsListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun numBtnClicked(view: View, num: String) {
        activityCallback?.entry(num)
    }

    private fun rootBtnClicked(view: View){
        activityCallback?.root()
    }

    private fun clearBtnClicked(view: View){
        activityCallback?.clear()
    }

    private fun equalsBtnClicked(view: View){
        activityCallback?.equals()
    }
}