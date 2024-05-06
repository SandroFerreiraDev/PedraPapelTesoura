package com.ferreirasandro.pedrapapeltesoura

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Game1x1Activity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var imgPlayerChoice: ImageView
    private lateinit var imgComputerChoice: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1x1)

        tvResult = findViewById(R.id.tvResult)
        imgPlayerChoice = findViewById(R.id.imgPlayerChoice)
        imgComputerChoice = findViewById(R.id.imgComputerChoice)

        findViewById<Button>(R.id.btnRock).setOnClickListener { playGame(CHOICE_ROCK) }
        findViewById<Button>(R.id.btnPaper).setOnClickListener { playGame(CHOICE_PAPER) }
        findViewById<Button>(R.id.btnScissors).setOnClickListener { playGame(CHOICE_SCISSORS) }
    }

    private fun playGame(playerChoice: Int) {
        val computerChoice = Random.nextInt(3)

        imgPlayerChoice.setImageResource(getImageResource(playerChoice))
        imgComputerChoice.setImageResource(getImageResource(computerChoice))

        val result = getResult(playerChoice, computerChoice)

        tvResult.text = result
    }

    private fun getImageResource(choice: Int): Int {
        return when (choice) {
            CHOICE_ROCK -> R.drawable.ic_rock
            CHOICE_PAPER -> R.drawable.ic_paper
            CHOICE_SCISSORS -> R.drawable.ic_scissors
            else -> throw IllegalArgumentException("Escolha inválida: $choice")
        }
    }

    private fun getResult(playerChoice: Int, computerChoice: Int): String {
        return when {
            playerChoice == computerChoice -> "Empate"
            playerChoice == CHOICE_ROCK && computerChoice == CHOICE_SCISSORS ||
                    playerChoice == CHOICE_PAPER && computerChoice == CHOICE_ROCK ||
                    playerChoice == CHOICE_SCISSORS && computerChoice == CHOICE_PAPER -> "Você ganhou!"
            else -> "Você perdeu!"
        }
    }

    companion object {
        private const val CHOICE_ROCK = 0
        private const val CHOICE_PAPER = 1
        private const val CHOICE_SCISSORS = 2
    }
}

