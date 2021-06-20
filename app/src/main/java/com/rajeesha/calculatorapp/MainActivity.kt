package com.rajeesha.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var tvInput: TextView

    private lateinit var btnAc: Button
    private lateinit var btnC: Button

    private lateinit var btnDivision: Button
    private lateinit var btnMultiplication: Button
    private lateinit var btnSubtraction: Button
    private lateinit var btnAdd: Button
    private lateinit var btnDecimal: Button

    private lateinit var btnResult: Button

    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button


    var input = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvInput = findViewById(R.id.tvInput)

        btnAc = findViewById(R.id.btnAc)
        btnC = findViewById(R.id.btnC)

        btnDivision = findViewById(R.id.btnDivision)
        btnMultiplication = findViewById(R.id.btnMultiplication)
        btnSubtraction = findViewById(R.id.btnSubtraction)
        btnAdd = findViewById(R.id.btnAdd)
        btnDecimal = findViewById(R.id.btnDecimal)
        btnResult = findViewById(R.id.btnResult)

        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

        btn0.setOnClickListener { buttonWhenClicked("0") }
        btn1.setOnClickListener { buttonWhenClicked("1") }
        btn2.setOnClickListener { buttonWhenClicked("2") }
        btn3.setOnClickListener { buttonWhenClicked("3") }
        btn4.setOnClickListener { buttonWhenClicked("4") }
        btn5.setOnClickListener { buttonWhenClicked("5") }
        btn6.setOnClickListener { buttonWhenClicked("6") }
        btn7.setOnClickListener { buttonWhenClicked("7") }
        btn8.setOnClickListener { buttonWhenClicked("8") }
        btn9.setOnClickListener { buttonWhenClicked("9") }

        btnAc.setOnClickListener {
            tvInput.text = ""
            input = ""
        }

        btnC.setOnClickListener {
            if (input != "") {
                input = input.subSequence(0, input.length - 1).toString()
                tvInput.text = input
            }
        }

        btnResult.setOnClickListener { result() }


        btnDivision.setOnClickListener { buttonWhenClicked("/") }
        btnMultiplication.setOnClickListener { buttonWhenClicked("x") }
        btnSubtraction.setOnClickListener { buttonWhenClicked("-") }
        btnAdd.setOnClickListener { buttonWhenClicked("+") }
        btnDecimal.setOnClickListener { buttonWhenClicked(".") }

    }

    fun buttonWhenClicked(buttons: String) {
        input += buttons
        tvInput.text = input

    }

    fun result() {
        var first = ""
        var second = ""
        var op = ""
        var current = ""
        var operation = mutableListOf("+", "x", "-", "/")
        for (i in input) {
            if (i.toString() in operation) {
                op = i.toString()
                if (first == "") {
                    first = current
                } else {
                    second = current
                }
                current = ""
            } else {
                current += i.toString()
            }
            if (first != "" && second != "" && op != "") {
                if (op == "+") {
                    first = (first.toFloat() + second.toFloat()).toString()
                } else if (op == "-") {
                    first = (first.toFloat() - second.toFloat()).toString()
                } else if (op == "x") {
                    first = (first.toFloat() * second.toFloat()).toString()
                } else if (op == "/") {
                    first = (first.toFloat() / second.toFloat()).toString()
                }
                second = ""
                op = ""
            }

        }
        second = current
        if (op == "+") {
            first = (first.toFloat() + second.toFloat()).toString()
        } else if (op == "-") {
            first = (first.toFloat() - second.toFloat()).toString()
        } else if (op == "x") {
            first = (first.toFloat() * second.toFloat()).toString()
        } else if (op == "/") {
            first = (first.toFloat() / second.toFloat()).toString()
        }
        tvInput.text = first
        first = ""
        second = ""
        op = ""
        input = ""


    }
}
