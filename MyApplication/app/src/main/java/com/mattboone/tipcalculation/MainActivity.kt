package com.mattboone.tipcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mattboone.tipcalculation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //setTitle("@String/title")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun calculateTip (view: View){
        if (binding.billAmount.text.isNotEmpty()) {
            val tenPercent = "%.2f".format(((binding.billAmount.text.toString().toFloat())*1.1))
            val fifteenPercent = "%.2f".format(((binding.billAmount.text.toString().toFloat())*1.15))
            val twentyPercent = "%.2f".format(((binding.billAmount.text.toString().toFloat())*1.2))
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