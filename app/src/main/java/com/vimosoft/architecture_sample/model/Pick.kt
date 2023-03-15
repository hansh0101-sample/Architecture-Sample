package com.vimosoft.architecture_sample.model

enum class Pick {
    ROCK {
        override fun checkGameResult(opponentPick: Pick): GameResult {
            return when (opponentPick) {
                ROCK -> GameResult.DRAW
                PAPER -> GameResult.LOSE
                SCISSORS -> GameResult.WIN
            }
        }
    },
    PAPER {
        override fun checkGameResult(opponentPick: Pick): GameResult {
            return when (opponentPick) {
                ROCK -> GameResult.WIN
                PAPER -> GameResult.DRAW
                SCISSORS -> GameResult.LOSE
            }
        }
    },
    SCISSORS {
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