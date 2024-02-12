package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.button)

        btn.setOnClickListener {
            calculateGrade()
        }
    }

    private fun calculateGrade() {
        // Accessing UI Components
        val editTextMark: EditText = findViewById(R.id.get_mark)
        val textViewGrade: TextView = findViewById(R.id.display_grade)
        val imageViewGif: pl.droidsonroids.gif.GifImageView = findViewById(R.id.gif)

        // Variables
        var msg = ""

        // GIF Resources
        val gradeAGif = R.drawable.grade_a
        val gradeBGif = R.drawable.grade_b
        val gradeCGif = R.drawable.grade_c
        val gradeDEGif = R.drawable.grade_d_e

        try{
            val inputMark: Int? = editTextMark.text.toString().toIntOrNull()

            if(inputMark != null){
                if(inputMark > 100 || inputMark < 0){
                    Toast.makeText(this, "Mark should be between 0-100", Toast.LENGTH_LONG).show()
                }
                else{
                    when(inputMark){
                        in 85..100 -> {
                            msg = "A+"
                            imageViewGif.setImageResource(gradeAGif)
                        }
                        in 70..84 -> {
                            msg = "A"
                            imageViewGif.setImageResource(gradeAGif)
                        }
                        in 65..69 -> {
                            msg = "A-"
                            imageViewGif.setImageResource(gradeAGif)
                        }
                        in 60..64 -> {
                            msg = "B+"
                            imageViewGif.setImageResource(gradeBGif)
                        }
                        in 55..59 -> {
                            msg = "B"
                            imageViewGif.setImageResource(gradeBGif)
                        }
                        in 50..54 -> {
                            msg = "B-"
                            imageViewGif.setImageResource(gradeBGif)
                        }
                        in 45..49 -> {
                            msg = "C+"
                            imageViewGif.setImageResource(gradeCGif)
                        }
                        in 40..44 -> {
                            msg = "C"
                            imageViewGif.setImageResource(gradeCGif)
                        }
                        in 35..39 -> {
                            msg = "C-"
                            imageViewGif.setImageResource(gradeCGif)
                        }
                        in 30..34 -> {
                            msg = "D+"
                            imageViewGif.setImageResource(gradeDEGif)
                        }
                        in 25..29 -> {
                            msg = "D"
                            imageViewGif.setImageResource(gradeDEGif)
                        }
                        in 0..24 -> {
                            msg = "E"
                            imageViewGif.setImageResource(gradeDEGif)
                        }
                    }
                }
            }
        }
        catch(e: NumberFormatException){
            Toast.makeText(this, "Mark cannot be null", Toast.LENGTH_LONG).show()
        }

        textViewGrade.text = msg
    }
}