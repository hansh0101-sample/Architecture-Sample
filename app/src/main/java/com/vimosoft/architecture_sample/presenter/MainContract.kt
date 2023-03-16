package com.vimosoft.architecture_sample.presenter

import com.vimosoft.architecture_sample.model.Pick
import com.vimosoft.architecture_sample.model.Player

interface MainContract {
    interface View {
        fun setResult(player1: Player, player2: Player)
    }

    interface Presenter {
        fun restart()
        fun setMyPick(pick: Pick)
    }
}