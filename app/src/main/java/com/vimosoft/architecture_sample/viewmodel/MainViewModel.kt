package com.vimosoft.architecture_sample.viewmodel

import androidx.databinding.ObservableField
import com.vimosoft.architecture_sample.model.Game
import com.vimosoft.architecture_sample.model.Pick
import com.vimosoft.architecture_sample.model.Player

class MainViewModel {
    private val game = Game { it.toList().shuffled().first() }
    val player1 = ObservableField<Player>()
    val player2 = ObservableField<Player>()

    fun restart() {
        game.restart()
    }

    fun setMyPick(pick: Pick) {
        game.setMyPick(pick)
        player1.set(game.getPlayer1().copy())
        player2.set(game.getPlayer2().copy())
    }
}