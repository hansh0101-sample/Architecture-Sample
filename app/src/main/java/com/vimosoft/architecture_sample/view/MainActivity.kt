package com.vimosoft.architecture_sample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vimosoft.architecture_sample.databinding.ActivityMainBinding
import com.vimosoft.architecture_sample.model.Game
import com.vimosoft.architecture_sample.model.Pick
import com.vimosoft.architecture_sample.model.Player
import com.vimosoft.architecture_sample.presenter.MainContract
import com.vimosoft.architecture_sample.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainPresenter = MainPresenter(this, Game { it.toList().shuffled().first() })
        initOnClickListener()
    }

    override fun setResult(player1: Player, player2: Player) {
        binding.run {
            imageMyPick.setImageResource(player1.pick?.resId ?: 0)
            textMyResult.text = player1.gameResult?.name ?: ""
            imageOpponentPick.setImageResource(player2.pick?.resId ?: 0)
            textOpponentResult.text = player2.gameResult?.name ?: ""
        }
    }

    private fun initOnClickListener() {
        with(binding) {
            imageScissors.setOnClickListener {
                mainPresenter.setMyPick(Pick.SCISSORS)
            }
            imageRock.setOnClickListener {
                mainPresenter.setMyPick(Pick.ROCK)
            }
            imagePaper.setOnClickListener {
                mainPresenter.setMyPick(Pick.PAPER)
            }
            buttonReset.setOnClickListener {
                mainPresenter.restart()
            }
        }
    }
}