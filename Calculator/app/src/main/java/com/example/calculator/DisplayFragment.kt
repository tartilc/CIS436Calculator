package com.example.calculator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.calculator.databinding.DisplayBinding
import javax.script.ScriptEngineManager
import javax.script.ScriptException


class DisplayFragment : Fragment() {

    private lateinit var binding: DisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun changeDisplayText(text: String){
        binding.displayText.text = binding.displayText.text.toString() + text
    }

    fun clearText(){
        binding.displayText.setText("");
    }

    fun calculate(){
        var result: Double? = null
        val engine = ScriptEngineManager().getEngineByName("rhino")
        try {
            result = engine.eval(binding.displayText.text.toString()) as Double
        } catch (e: ScriptException) {
            Toast.makeText(getActivity(),"Invalid",Toast.LENGTH_SHORT).show();
        }

        binding.displayText.text = result.toString()
    }

    fun calculateRoot(){
        var result: Double? = null
        val engine = ScriptEngineManager().getEngineByName("rhino")
        try {
            result = engine.eval("Math.sqrt(" + binding.displayText.text.toString() + ")") as Double
        } catch (e: ScriptException) {
            Toast.makeText(getActivity(),"Invalid",Toast.LENGTH_SHORT).show();
        }

        binding.displayText.text = result.toString()
    }
}