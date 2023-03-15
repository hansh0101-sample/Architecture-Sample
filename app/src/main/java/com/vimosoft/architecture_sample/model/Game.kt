package com.vimosoft.architecture_sample.model

class Game() {
    private var player1: Player = Player()
    private var player2: Player = Player()

    fun restart() {
        player1 = Player()
        player2 = Player()
    }

    fun setMyPick(pick: Pick) {
        player1.pick = pick
        player2.pick = Pick.values().toList().shuffled().first()
        checkGameResult()
    }

    fun getPlayer1(): Player {
        return player1
    }

    fun getPlayer2(): Player {
        return player2
    }

    private fun checkGameResult() {
        if (player1.pick == null || player2.pick == null) {
            return
        }

        player1.gameResult = player1.pick!!.checkGameResult(player2.pick!!)
        player2.gameResult = player2.pick!!.checkGameResult(player1.pick!!)
    }
}