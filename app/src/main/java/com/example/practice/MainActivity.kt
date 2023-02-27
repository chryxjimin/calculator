package com.example.practice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    var operatorButtonClicked = false
    var equalsButtonClicked = false
    val inputList = mutableListOf<Int>()
    val operatorList = mutableListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val allClearButton = findViewById<Button>(R.id.AC)
        val backspaceButton = findViewById<Button>(R.id.backspace)

        var allClearOperatorListener = allClearButton.setOnClickListener {
            allClearButton()
        }

        var backspaceOperatorListener = backspaceButton.setOnClickListener {
            val initialInput = total.text.toString().toInt()
            backspaceButton(initialInput)
        }

        equals.setOnClickListener {
            inputList.add(total.text.toString().toInt())
            Toast.makeText(this@MainActivity, "inputList: ${inputList} ", Toast.LENGTH_SHORT).show()
            equalsButtonClicked = true

            if (equalsButtonClicked) {
                when(operatorList[0]) {
                    "+" -> addNumbers()
                    "-" -> subtractNumbers()
                    "X" -> multiplyNumbers()
                    "/" -> divideNumbers()
                }
            }
            operatorList.clear()
        }
    }

        fun multiplyNumbers() {
            val firstInput = inputList[0]
            val secondInput = inputList[1]
            val sum = firstInput * secondInput
            total.text = ""
            total.text = "$sum"
        }

        fun divideNumbers() {
            val firstInput = inputList[0]
            val secondInput = inputList[1]
            val sum = firstInput / secondInput
            total.text = ""
            total.text = "$sum"
        }

        fun addNumbers() {
            val firstInput = inputList[0]
            val secondInput = inputList[1]
            val sum = firstInput + secondInput
            total.text = ""
            total.text = "$sum"
        }

        fun subtractNumbers() {
            val firstInput = inputList[0]
            val secondInput = inputList[1]
            val sum = firstInput - secondInput
            total.text = ""
            total.text = "$sum"
        }

        fun backspaceButton(initialInput: Int) {
            val textView = findViewById<Button>(R.id.total) as TextView
            var length = textView.length()
            if (length > 0 && textView.text != "") {
                textView.text = initialInput.toString().subSequence(0, length - 1)
            }
            if (textView.text == "" ){
            textView.text = "0"
            }
        }

        fun allClearButton() {
            var textView = findViewById<Button>(R.id.total) as TextView
            textView.text = "0"
            inputList.clear()
        }

        fun numberEvent(view: View) {
            var buttonInput = (view as Button).text.toString()

            if (view is Button){
                if (operatorButtonClicked) {
                    total.text = ""
                    total.text = total.text.toString().plus(buttonInput)
                    operatorButtonClicked = false
                } else if (total.text.toString().toInt() == 0){
                    total.text = ""
                    total.text = total.text.toString().plus(buttonInput)
                }
                else if (total.text != "") {
                    total.text = total.text.toString().plus(buttonInput)
                } else if (total.text == "") {
                    total.text = total.text.toString().plus(buttonInput)
                } else {
                    total.text = total.text
                }
            }
        }


        fun operatorEvent(view: View) {
            operatorButtonClicked = true
            inputList.add(total.text.toString().toInt())

            if (view is Button && operatorButtonClicked) {
                operatorList.add(view.text)
            }

        }

}








