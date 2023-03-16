package com.vimosoft.architecture_sample.presenter

import com.vimosoft.architecture_sample.model.Game
import com.vimosoft.architecture_sample.model.Pick

class MainPresenter(private val view: MainContract.View, private val game: Game) :
    MainContract.Presenter {
    override fun restart() {
        game.restart()
        view.setResult(game.getPlayer1(), game.getPlayer2())
    }

    override fun setMyPick(pick: Pick) {
        game.setMyPick(pick)
        view.setResult(game.getPlayer1(), game.getPlayer2())
    }
}