package com.ferreirasandro.pedrapapeltesoura

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Game1x1x1Activity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var imgPlayerChoice: ImageView
    private lateinit var imgComputerChoice1: ImageView
    private lateinit var imgComputerChoice2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1x1x1)

        tvResult = findViewById(R.id.tvResult)
        imgPlayerChoice = findViewById(R.id.imgPlayerChoice)
        imgComputerChoice1 = findViewById(R.id.imgComputerChoice1)
        imgComputerChoice2 = findViewById(R.id.imgComputerChoice2)

        findViewById<Button>(R.id.btnRock).setOnClickListener { playGame(CHOICE_ROCK) }
        findViewById<Button>(R.id.btnPaper).setOnClickListener { playGame(CHOICE_PAPER) }
        findViewById<Button>(R.id.btnScissors).setOnClickListener { playGame(CHOICE_SCISSORS) }
    }

    private fun playGame(playerChoice: Int) {
        val computerChoice1 = Random.nextInt(3)
        val computerchoice2 = Random.nextInt(3)

        imgPlayerChoice.setImageResource(getImageResource(playerChoice))
        imgComputerChoice1.setImageResource(getImageResource(computerChoice1))
        imgComputerChoice2.setImageResource(getImageResource(computerchoice2))

        val result = getResult(playerChoice, computerChoice1, computerchoice2)

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

    private fun getResult(playerChoice: Int, computerChoice1: Int, computerChoice2: Int): String {
        return when {
            playerChoice == computerChoice1 && playerChoice == computerChoice2 -> "Empate"
            playerChoice == computerChoice1 || playerChoice == computerChoice2 ||
                    computerChoice1 == computerChoice2 -> "Você ganhou!"
            else -> "Você perdeu!"
        }
    }

    companion object {
        private const val CHOICE_ROCK = 0
        private const val CHOICE_PAPER = 1
        private const val CHOICE_SCISSORS = 2
    }
}
