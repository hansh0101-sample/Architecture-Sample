package com.vimosoft.architecture_sample.model

import com.vimosoft.architecture_sample.R

enum class Pick(val resId: Int) {
    ROCK(R.drawable.rock) {
        override fun checkGameResult(opponentPick: Pick): GameResult {
            return when (opponentPick) {
                ROCK -> GameResult.DRAW
                PAPER -> GameResult.LOSE
                SCISSORS -> GameResult.WIN
            }
        }
    },
    PAPER(R.drawable.paper) {
        override fun checkGameResult(opponentPick: Pick): GameResult {
            return when (opponentPick) {
                ROCK -> GameResult.WIN
                PAPER -> GameResult.DRAW
                SCISSORS -> GameResult.LOSE
            }
        }
    },
    SCISSORS(R.drawable.scissors) {
        override fun checkGameResult(opponentPick: Pick): GameResult {
            return when (opponentPick) {
                ROCK -> GameResult.LOSE
                PAPER -> GameResult.WIN
                SCISSORS -> GameResult.DRAW
            }
        }
    };

    abstract fun checkGameResult(opponentPick: Pick): GameResult
}