package com.vimosoft.architecture_sample.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vimosoft.architecture_sample.databinding.ActivityMainBinding
import com.vimosoft.architecture_sample.model.Game
import com.vimosoft.architecture_sample.model.Pick
import com.vimosoft.architecture_sample.model.Player

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val game: Game by lazy { Game { it.toList().shuffled().first() } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initOnClickListener()
    }

    private fun initOnClickListener() {
        with(binding) {
            imageScissors.setOnClickListener {
                game.setMyPick(Pick.SCISSORS)
                setResult(game.getPlayer1(), game.getPlayer2())
            }
            imageRock.setOnClickListener {
                game.setMyPick(Pick.ROCK)
                setResult(game.getPlayer1(), game.getPlayer2())
            }
            imagePaper.setOnClickListener {
                game.setMyPick(Pick.PAPER)
                setResult(game.getPlayer1(), game.getPlayer2())
            }
            buttonReset.setOnClickListener {
                game.restart()
                setResult(game.getPlayer1(), game.getPlayer2())
            }
        }
    }

    private fun setResult(player1: Player, player2: Player) {
        binding.run {
            imageMyPick.setImageResource(player1.pick?.resId ?: 0)
            textMyResult.text = player1.gameResult?.name ?: ""
            imageOpponentPick.setImageResource(player2.pick?.resId ?: 0)
            textOpponentResult.text = player2.gameResult?.name ?: ""
        }
    }
}