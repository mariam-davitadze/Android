package com.example.calculatorhometask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var resultresultTextView: TextView

    private var firstNumber = ""
    private var secondNumber = ""
    private var isOperatorClicked = false
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
        resultresultTextView = findViewById(R.id.resultresultTextView)
    }

    @SuppressLint("SetTextI18n")
    fun numberClick(view: View) {
        if (view is TextView) {
            val number: String = view.text.toString()
            if(!isOperatorClicked){
                var result: String = firstNumber
                if (result == "0") {
                    result = ""
                }
                firstNumber = result + number
                resultresultTextView.text = ""
                resultTextView.text = result + number
            }else{
                var result: String = secondNumber
                if (result == "0") {
                    result = ""
                }
                secondNumber = result + number
                resultresultTextView.text = ""
                resultTextView.text = "$firstNumber$operation${result + number}"
            }
        }

    }

    @SuppressLint("SetTextI18n")
    fun operationClick(view: View) {
        if (view is TextView) {
            if(firstNumber != ""){
                operation = view.text.toString()
                resultTextView.text = resultTextView.text.toString() + operation
            } else{
                Toast.makeText(this, "please input first number", Toast.LENGTH_SHORT).show()
            }
            isOperatorClicked = true
        }

    }

    fun equalsClick(view: View) {
        if(firstNumber != "" && secondNumber != ""){
            when (operation) {
                "+" -> resultresultTextView.text = (firstNumber.toDouble() + secondNumber.toDouble()).toString().removeSuffix(".0")
                "-" -> resultresultTextView.text = (firstNumber.toDouble() - secondNumber.toDouble()).toString().removeSuffix(".0")
                "*" -> resultresultTextView.text = (firstNumber.toDouble() * secondNumber.toDouble()).toString().removeSuffix(".0")
                "/" -> resultresultTextView.text = (firstNumber.toDouble() / secondNumber.toDouble()).toString().removeSuffix(".0")
            }
        }
        isOperatorClicked = false
        firstNumber = ""
        secondNumber = ""
    }

    @SuppressLint("SetTextI18n")
    fun delClick(view: View) {
        if(!isOperatorClicked){
            if (firstNumber.isNotEmpty()) {
                firstNumber = firstNumber.dropLast(1)
                resultTextView.text = firstNumber
                isOperatorClicked = false
            }else if (firstNumber.isEmpty()) {
                operation = ""
                isOperatorClicked = false
                secondNumber = ""
                firstNumber = ""
                resultresultTextView.text = ""
            }
        }else{
            if (secondNumber.isNotEmpty()) {
                secondNumber = secondNumber.dropLast(1)
                resultTextView.text = "$firstNumber$operation$secondNumber"
            }else if (secondNumber.isEmpty()) {
                operation = ""
                secondNumber = ""
                isOperatorClicked = false
                resultTextView.text = resultTextView.text.dropLast(1)
                resultresultTextView.text = ""
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun dotClick(view: View) {
        if(!isOperatorClicked){
            if (!firstNumber.contains(".")){
                firstNumber = "$firstNumber."
                resultTextView.text = firstNumber + "0"
            }
        }else{
            if (!secondNumber.contains(".")){
                secondNumber += "."
                resultTextView.text = resultTextView.text.toString() + ".0"
            }
        }
    }
}