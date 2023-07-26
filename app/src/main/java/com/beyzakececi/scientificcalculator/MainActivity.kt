package com.beyzakececi.scientificcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.beyzakececi.scientificcalculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.displayEditText?.showSoftInputOnFocus = false


        binding.zero.setOnClickListener { onNumberButtonClick("0") }
        binding.one.setOnClickListener { onNumberButtonClick("1") }
        binding.two.setOnClickListener { onNumberButtonClick("2") }
        binding.three.setOnClickListener { onNumberButtonClick("3") }
        binding.four.setOnClickListener { onNumberButtonClick("4") }
        binding.five.setOnClickListener { onNumberButtonClick("5") }
        binding.six.setOnClickListener { onNumberButtonClick("6") }
        binding.seven.setOnClickListener { onNumberButtonClick("7") }
        binding.eight.setOnClickListener { onNumberButtonClick("8") }
        binding.nine.setOnClickListener { onNumberButtonClick("9") }
        binding.pointButton.setOnClickListener { onNumberButtonClick(".") }
        binding.openParanthesesButton.setOnClickListener { onNumberButtonClick("(") }
        binding.closeParanthesesButton.setOnClickListener { onNumberButtonClick(")") }
        binding.addButton.setOnClickListener { onNumberButtonClick("+") }
        binding.subsractButton.setOnClickListener { onNumberButtonClick("-") }
        binding.multiplyButton.setOnClickListener { onNumberButtonClick("*") }
        binding.divideButton.setOnClickListener { onNumberButtonClick("/") }

        binding.sinButton?.setOnClickListener { onNumberButtonClick("sin(") }
        binding.cosButton?.setOnClickListener { onNumberButtonClick("cos(") }
        binding.tanButton?.setOnClickListener { onNumberButtonClick("tan(") }
        binding.arcsin?.setOnClickListener { onNumberButtonClick("arcsin(") }
        binding.arccos?.setOnClickListener { onNumberButtonClick("arccos(") }
        binding.arctan?.setOnClickListener { onNumberButtonClick("arctan(") }
        binding.logButton?.setOnClickListener { onNumberButtonClick("log(") }
        binding.lnButton?.setOnClickListener { onNumberButtonClick("ln(") }
        binding.absolute?.setOnClickListener { onNumberButtonClick("abs(") }
        binding.pi?.setOnClickListener { onNumberButtonClick("pi") }
        binding.eButton?.setOnClickListener { onNumberButtonClick("e") }
        binding.sqrtButton?.setOnClickListener { onNumberButtonClick("^(2)") }
        binding.xsquarey?.setOnClickListener { onNumberButtonClick("^(") }
        binding.factoriel?.setOnClickListener { onNumberButtonClick("!") }



        // Set click listener for the "Clear" button
        binding.clearButton.setOnClickListener { onClearButtonClick() }

        // Set click listener for the "Equal" button
        binding.equalsButton.setOnClickListener { onEqualButtonClick() }

        // Set click listener for the "Backspace" button
        binding.backspaceButton.setOnClickListener { onBackspaceButtonClick() }


    }

    private fun updateText(strToAdd: String) {
        val oldStr = binding.displayEditText?.text.toString()
        val cursorPos = binding.displayEditText?.selectionStart
        val leftStr = cursorPos?.let { oldStr.substring(0, it) }
        val rightStr = cursorPos?.let { oldStr.substring(it) }
        binding.displayEditText?.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
        binding.displayEditText?.setSelection(cursorPos?.plus(strToAdd.length) ?: 0)
    }

    private fun onBackspaceButtonClick() {
        val cursorPos = binding.displayEditText?.selectionStart
        val textLen = binding.displayEditText?.text?.length
        if (cursorPos != null && textLen != null) {
            if (cursorPos != 0 && textLen != 0) {
                val selection = cursorPos - 1
                val text = binding.displayEditText?.text
                text?.delete(selection, cursorPos)
                binding.displayEditText?.setSelection(selection)
            }
        }
    }

    private fun convertToDecimal() {
        val text = binding.displayEditText?.text.toString()
        val result = text.toDouble()
        binding.displayEditText?.setText(result.toString())
    }

    private fun onEqualButtonClick() {
        var userExp = binding.displayEditText?.text.toString()
        binding.previousCalculationView?.text= userExp
        userExp = userExp.replace(resources.getString(R.string.divideText), "/")
        userExp = userExp.replace(resources.getString (R.string.multiplyText), "*")
        val exp = Expression(userExp)
        val result = exp.calculate().toString()
        binding.displayEditText?.setText(result)

    }

    private fun onClearButtonClick() {
        binding.displayEditText?.text?.clear()
        binding.previousCalculationView.text = ""
    }

    private fun onNumberButtonClick(s: String) {
        binding.displayEditText?.append(s)
    }


}


