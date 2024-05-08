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

        findViewById<Button>(R.id.btnSpock).setOnClickListener { playGame(CHOICE_SPOCK) }
        findViewById<Button>(R.id.btnLizard).setOnClickListener { playGame(CHOICE_LIZARD) }
        findViewById<Button>(R.id.btnRock).setOnClickListener { playGame(CHOICE_ROCK) }
        findViewById<Button>(R.id.btnPaper).setOnClickListener { playGame(CHOICE_PAPER) }
        findViewById<Button>(R.id.btnScissors).setOnClickListener { playGame(CHOICE_SCISSORS) }
    }

    private fun playGame(playerChoice: Int) {
        val computerChoice = Random.nextInt(5)

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
            CHOICE_SPOCK -> R.drawable.ic_spock
            CHOICE_LIZARD-> R.drawable.ic_lizard

            else -> throw IllegalArgumentException("Escolha inválida: $choice")
        }
    }

    private fun getResult(playerChoice: Int, computerChoice: Int): String {
        return when {
            playerChoice == computerChoice -> "Empate"
            playerChoice == CHOICE_ROCK && computerChoice == CHOICE_SCISSORS ||
                    playerChoice == CHOICE_PAPER && computerChoice == CHOICE_ROCK ||
                    playerChoice == CHOICE_SCISSORS && computerChoice == CHOICE_PAPER ||
                    playerChoice == CHOICE_SCISSORS && computerChoice == CHOICE_LIZARD ||
                    playerChoice == CHOICE_PAPER && computerChoice == CHOICE_SPOCK ||
                    playerChoice == CHOICE_SPOCK && computerChoice == CHOICE_ROCK ||
                    playerChoice == CHOICE_SPOCK && computerChoice == CHOICE_SCISSORS ||
                    playerChoice == CHOICE_LIZARD && computerChoice == CHOICE_SPOCK ||
                    playerChoice == CHOICE_LIZARD && computerChoice == CHOICE_PAPER ||
                    playerChoice == CHOICE_ROCK && computerChoice == CHOICE_LIZARD-> "Você ganhou!"
            else -> "Você perdeu!"
        }
    }

    companion object {
        private const val CHOICE_ROCK = 0
        private const val CHOICE_PAPER = 1
        private const val CHOICE_SCISSORS = 2
        private const val CHOICE_SPOCK = 3
        private const val CHOICE_LIZARD = 4
    }
}

