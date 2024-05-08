package com.casaque.pedrapapeltesoura

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvBot1Choice: TextView
    private lateinit var tvBot2Choice: TextView
    private lateinit var rgPlayers: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRock = findViewById<Button>(R.id.btnRock)
        val btnPaper = findViewById<Button>(R.id.btnPaper)
        val btnScissors = findViewById<Button>(R.id.btnScissors)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        tvBot1Choice = findViewById(R.id.tvBot1Choice)
        tvBot2Choice = findViewById(R.id.tvBot2Choice)
        rgPlayers = findViewById(R.id.rgPlayers)

        btnRock.setOnClickListener { playGame(Choice.ROCK) }
        btnPaper.setOnClickListener { playGame(Choice.PAPER) }
        btnScissors.setOnClickListener { playGame(Choice.SCISSORS) }
    }

    private fun playGame(userChoice: Choice) {
        val numPlayers = if (rgPlayers.checkedRadioButtonId == R.id.rbTwoPlayers) 1 else 2
        val computerChoices = getComputerChoice(numPlayers)
        val result = determineWinner(userChoice, computerChoices)

        tvBot1Choice.text = "Escolha do Bot 1: ${computerChoices[0]}"
        if (numPlayers > 1) {
            tvBot2Choice.visibility = View.VISIBLE
            tvBot2Choice.text = "Escolha do Bot 2: ${computerChoices[1]}"
        } else {
            tvBot2Choice.visibility = View.GONE
        }

        findViewById<TextView>(R.id.tvResult).text = result
    }
}
