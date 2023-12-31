package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{calculate_tip()}
    }

    fun calculate_tip(){
        val cost = binding.costOfService.text.toString().toDouble()
        val opt = binding.tipOption.checkedRadioButtonId
        val percentage = when(opt){
            binding.optTwentyPercent.id -> 0.20
            binding.optFifteenPercent.id -> 0.15
            else -> 0.10
        }
        var tip_amount:Double = cost * percentage
        if (binding.roundUpSwitch.isChecked){
            tip_amount = round(tip_amount)
        }

        binding.tipAmount.text = tip_amount.toString()
    }
}