package com.casaque.pedrapapeltesoura

enum class Choice {
    ROCK, PAPER, SCISSORS
}

fun getComputerChoice(numPlayers: Int): List<Choice> {
    return List(numPlayers) { Choice.values().random() }
}

fun determineWinner(userChoice: Choice, computerChoices: List<Choice>): String {
    val results = computerChoices.map { compareChoices(userChoice, it) }
    val wins = results.count { it == "Win" }
    val losses = results.count { it == "Lose" }

    return when {
        wins > 0 && losses == 0 -> "Você ganhou!"
        losses > 0 && wins == 0 -> "Você perdeu!"
        else -> "Empate!"
    }
}

fun compareChoices(userChoice: Choice, computerChoice: Choice): String {
    return if (userChoice == computerChoice) {
        "Draw"
    } else if ((userChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
        (userChoice == Choice.PAPER && computerChoice == Choice.ROCK) ||
        (userChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)) {
        "Win"
    } else {
        "Lose"
    }
}