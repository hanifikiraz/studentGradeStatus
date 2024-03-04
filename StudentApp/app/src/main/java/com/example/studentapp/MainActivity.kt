package com.example.studentapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.studentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var totalPoint = 0f
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var numberOne : Float?
        var numberTwo : Float?


        binding.calculateButton.setOnClickListener()
        {
             numberOne = binding.noteOne.text.toString().toFloatOrNull()
             numberTwo = binding.noteTwo.text.toString().toFloatOrNull()
            if (numberOne != null && numberTwo != null)
            {
                if (numberOne!! >= 0 && numberOne!!<=100  && numberTwo!! >= 0 && numberTwo!! <=100)
                {
                     totalPoint = (numberOne!! + numberTwo!!) /2
                    when {
                        totalPoint < 25 -> sendToastMessage("You Didn't Pass the Course")
                        totalPoint < 50 -> sendToastMessage("You barely passed the lesson")
                        totalPoint < 75 -> sendToastMessage("You passed the lesson but you can get better.")
                        else -> sendToastMessage("You have successfully passed the lesson.")
                    }
                }
                else
                {
                    binding.studentStatusText.text = "Enter valid values between 0 and 100"
                }
            }
            else
            {
                sendToastMessage("Fill in the blanks.")
            }
        }
        binding.noteOne.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.studentStatusText.text = ""
            }
        }

        binding.noteTwo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.studentStatusText.text = ""
            }
        }
    }
    private fun sendToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        binding.studentStatusText.text = message + " Your Point ${totalPoint}"
    }
}