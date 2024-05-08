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

        findViewById<Button>(R.id.btnSpock).setOnClickListener { playGame(CHOICE_SPOCK) }
        findViewById<Button>(R.id.btnLizard).setOnClickListener { playGame(CHOICE_LIZARD) }
        findViewById<Button>(R.id.btnRock).setOnClickListener { playGame(CHOICE_ROCK) }
        findViewById<Button>(R.id.btnPaper).setOnClickListener { playGame(CHOICE_PAPER) }
        findViewById<Button>(R.id.btnScissors).setOnClickListener { playGame(CHOICE_SCISSORS) }
    }

    private fun playGame(playerChoice: Int) {
        val computerChoice1 = Random.nextInt(5)
        val computerchoice2 = Random.nextInt(5)

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
            CHOICE_SPOCK -> R.drawable.ic_spock
            CHOICE_LIZARD -> R.drawable.ic_lizard

            else -> throw IllegalArgumentException("Escolha inválida: $choice")
        }
    }

    private fun getResult(playerChoice: Int, computerChoice1: Int, computerChoice2: Int): String {
        return when {
            playerChoice == computerChoice1 && playerChoice == computerChoice2 -> "Empate"


            (playerChoice == CHOICE_PAPER && computerChoice1 == CHOICE_ROCK ||
                    playerChoice == CHOICE_SCISSORS && computerChoice1 == CHOICE_PAPER ||
                    playerChoice == CHOICE_SCISSORS && computerChoice1 == CHOICE_LIZARD ||
                    playerChoice == CHOICE_PAPER && computerChoice1 == CHOICE_SPOCK ||
                    playerChoice == CHOICE_SPOCK && computerChoice1 == CHOICE_ROCK ||
                    playerChoice == CHOICE_SPOCK && computerChoice1 == CHOICE_SCISSORS ||
                    playerChoice == CHOICE_LIZARD && computerChoice1 == CHOICE_SPOCK ||
                    playerChoice == CHOICE_LIZARD && computerChoice1 == CHOICE_PAPER ||
                    playerChoice == CHOICE_ROCK && computerChoice1 == CHOICE_LIZARD) &&
                    (playerChoice == CHOICE_PAPER && computerChoice2 == CHOICE_ROCK ||
                    playerChoice == CHOICE_SCISSORS && computerChoice2 == CHOICE_PAPER ||
                    playerChoice == CHOICE_SCISSORS && computerChoice2 == CHOICE_LIZARD ||
                    playerChoice == CHOICE_PAPER && computerChoice2 == CHOICE_SPOCK ||
                    playerChoice == CHOICE_SPOCK && computerChoice2 == CHOICE_ROCK ||
                    playerChoice == CHOICE_SPOCK && computerChoice2 == CHOICE_SCISSORS ||
                    playerChoice == CHOICE_LIZARD && computerChoice2 == CHOICE_SPOCK ||
                    playerChoice == CHOICE_LIZARD && computerChoice2 == CHOICE_PAPER ||
                    playerChoice == CHOICE_ROCK && computerChoice2 == CHOICE_LIZARD)
            -> "Você ganhou!"
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
