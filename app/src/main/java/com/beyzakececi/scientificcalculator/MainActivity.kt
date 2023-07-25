package com.beyzakececi.scientificcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.beyzakececi.scientificcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //create view binding

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // set show soft input on focus is false
        //binding.displayEditText?.showSoftInputOnFocus(false)


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


        // Set click listener for the "Clear" button
        binding.clearButton.setOnClickListener { onClearButtonClick() }

        // Set click listener for the "Equal" button
        binding.equalsButton.setOnClickListener { onEqualButtonClick() }

        // Set click listener for the "Backspace" button
        binding.backspaceButton.setOnClickListener { onBackspaceButtonClick() }






    }

    private fun onBackspaceButtonClick() {
        val text = binding.displayEditText?.text.toString()
        if (text.isNotEmpty()) {
            binding.displayEditText?.text?.delete(text.length - 1, text.length)
        }
    }

    private fun convertToDecimal() {
        val text = binding.displayEditText?.text.toString()
        val result = text.toDouble()
        binding.displayEditText?.setText(result.toString())
    }

    private fun onEqualButtonClick() {
        val text = binding.displayEditText?.text.toString()

    }

    private fun onClearButtonClick() {
        binding.displayEditText?.text?.clear()
    }

    private fun onNumberButtonClick(s: String) {
        binding.displayEditText?.append(s)
    }


}