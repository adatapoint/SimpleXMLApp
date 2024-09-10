package com.mercadopago.android.clasemaru

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private var isIncreasing = false

    private val rbCounterMode by lazy { findViewById<RadioGroup>(R.id.rgCounterMode) }
    private val rbIncrement by lazy { findViewById<RadioButton>(R.id.rbIncrease) }
    private val rbDecrement by lazy { findViewById<RadioButton>(R.id.rbDecrease) }
    private val tvNumber by lazy { findViewById<TextView>(R.id.tvNumber) }
    private val actionButton by lazy { findViewById<Button>(R.id.actionButton) }
    private val resetButton by lazy { findViewById<Button>(R.id.btnResetCounter) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        rbCounterMode.setOnCheckedChangeListener { _, checkedId ->
            isIncreasing = checkedId == rbIncrement.id
            updateUi()
            Log.d("APP", "isIncreasing: $isIncreasing")
        }

        actionButton.setOnClickListener {
            if (isIncreasing) {
                counter++
            } else {
                counter--
            }
            updateUi()
            Log.d("APP", "counter: $counter")
        }

        resetButton.setOnClickListener {
            counter = 0
            updateUi()
        }
    }

    private fun updateCounterMode(isIncreasing: Boolean) {
        this.isIncreasing = isIncreasing
    }

    private fun updateUi() {
        tvNumber.text = counter.toString()

        if (isIncreasing) {
            actionButton.text = "Increase"
        } else {
            actionButton.text = "Decrease"
        }
    }
}