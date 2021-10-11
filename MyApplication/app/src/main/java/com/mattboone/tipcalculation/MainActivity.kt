package com.mattboone.tipcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mattboone.tipcalculation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun calculateTip (view: View){
        if (binding.billAmount.text.isNotEmpty()) {
            val tenPercent = (binding.billAmount.text.toString().toFloat())*0.1
            val fifteenPercent = (binding.billAmount.text.toString().toFloat())*0.15
            val twentyPercent = (binding.billAmount.text.toString().toFloat())*0.2
            binding.output.text = ("The tips are as follows:\n" +
                    "\n10% = " + tenPercent +
                    "\n15% = " + fifteenPercent +
                    "\n20% = " + twentyPercent)
        }
        else {
            binding.output.text = "YOU MUST ENTER A BILL AMOUNT"
        }
    }
}