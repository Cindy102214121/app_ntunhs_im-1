package com.example.play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var txtcom: TextView
    private lateinit var txtResult: TextView
    private lateinit var btnscissors: ImageButton
    private lateinit var btnrock: ImageButton
    private lateinit var btnpaper: ImageButton
    private lateinit var imageView:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtcom = findViewById(R.id.txtcom)
        txtResult = findViewById(R.id.txtResult)
        btnscissors = findViewById(R.id.imbtnscissors)
        btnrock = findViewById(R.id.imbtnrock)
        btnpaper = findViewById(R.id.imbtnpaper)
        imageView = findViewById(R.id.imageView)

        btnscissors.setOnClickListener {
            playGame(Choice.scissors)
        }
        btnrock.setOnClickListener {
            playGame(Choice.rock)
        }
        btnpaper.setOnClickListener {
            playGame(Choice.paper)
        }

//        val txtcom = findViewById<TextView>(R.id.txtcom)
//        val txtResult = findViewById<TextView>(R.id.txtResult)
//        val btnscissors = findViewById<Button>(R.id.btnscissors)
//        val btnrock = findViewById<Button>(R.id.btnrock)
//        val btnpaper = findViewById<Button>(R.id.btnpaper)

//        btnrock.setOnClickListener {
//            val iComPlay = Random().nextInt(3)+1
//
//            when(iComPlay){
//                1->{
//                    txtcom.setText(R.string.scissors)
//                    txtResult.setText(getString(R.string.win))
//                }
//                2->{
//                    txtcom.setText(R.string.rock)
//                    txtResult.setText(getString(R.string.draw))
//                }
//                3->{
//                    txtcom.setText(R.string.paper)
//                    txtResult.setText(getString(R.string.lose))
//                }
//            }
//        }
//
//        btnscissors.setOnClickListener {
//            val iComPlay = Random().nextInt(3)+1
//
//            when(iComPlay){
//                1->{
//                    txtcom.setText(R.string.scissors)
//                    txtResult.setText(getString(R.string.draw))
//                }
//                2->{
//                    txtcom.setText(R.string.rock)
//                    txtResult.setText(getString(R.string.lose))
//                }
//                3->{
//                    txtcom.setText(R.string.paper)
//                    txtResult.setText(getString(R.string.win))
//                }
//            }
//        }

//        btnpaper.setOnClickListener {
//            val iComPlay = Random().nextInt(3)+1
//
//            when(iComPlay){
//                1->{
//                    txtcom.setText(R.string.scissors)
//                    txtResult.setText(getString(R.string.lose))
//                }
//                2->{
//                    txtcom.setText(R.string.rock)
//                    txtResult.setText(getString(R.string.win))
//                }
//                3->{
//                    txtcom.setText(R.string.paper)
//                    txtResult.setText(getString(R.string.draw))
//                }
//            }
//        }

    }

    enum class Choice {
        scissors,rock,paper
    }
    fun playGame(playerChoice: Choice) {
        val computerChoice = Choice.values()[Random.nextInt(Choice.values().size)]

        when {
            playerChoice == computerChoice -> {
                txtcom.setText(getChoiceString(computerChoice))
                imageView.setImageResource(getDrawableResource(computerChoice))
                txtResult.setText(R.string.draw)
            }
            (playerChoice == Choice.scissors && computerChoice == Choice.paper) ||
                    (playerChoice == Choice.rock && computerChoice == Choice.scissors) ||
                    (playerChoice == Choice.paper && computerChoice == Choice.rock) -> {
                txtcom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.win)
                imageView.setImageResource(getDrawableResource(computerChoice))
            }
            else -> {
                txtcom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.lose)
                imageView.setImageResource(getDrawableResource(computerChoice))
            }
        }
    }


    fun getChoiceString(choice: Choice):Int {
        return when (choice) {
            Choice.scissors ->R.string.scissors
            Choice.rock -> R.string.rock
            Choice.paper ->R.string.paper
        }
    }
    fun getDrawableResource(choice: Choice):Int {
        return when (choice) {
            Choice.scissors ->R.drawable.scissor
            Choice.rock -> R.drawable.rock
            Choice.paper ->R.drawable.paper
        }
    }

}