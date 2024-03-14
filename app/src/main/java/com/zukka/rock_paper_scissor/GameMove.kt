package com.zukka.rock_paper_scissor

import kotlin.random.Random

sealed class GameMove {
    object Rock: GameMove()
    object Paper: GameMove()
    object Scissors: GameMove()
}

fun getRandomGameMove(): GameMove {
    return when (Random.nextInt(3)) {
        0 -> GameMove.Rock
        1 -> GameMove.Paper
        else -> GameMove.Scissors
    }
}