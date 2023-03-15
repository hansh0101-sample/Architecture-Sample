package com.vimosoft.architecture_sample.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vimosoft.architecture_sample.R
import com.vimosoft.architecture_sample.databinding.ActivityMainBinding
import com.vimosoft.architecture_sample.model.Game
import com.vimosoft.architecture_sample.model.GameResult
import com.vimosoft.architecture_sample.model.Pick
import com.vimosoft.architecture_sample.model.Player

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initOnClickListener()
        initGame()
    }

    // View 초기화
    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // User Input에 대해 Model과의 상호작용 후 View 갱신
    private fun initOnClickListener() {
        with (binding) {
            imageScissors.setOnClickListener {
                game.setMyPick(Pick.SCISSORS)
                setMyResult(game.getPlayer1())
                setOpponentResult(game.getPlayer2())
            }
            imageRock.setOnClickListener {
                game.setMyPick(Pick.ROCK)
                setMyResult(game.getPlayer1())
                setOpponentResult(game.getPlayer2())
            }
            imagePaper.setOnClickListener {
                game.setMyPick(Pick.PAPER)
                setMyResult(game.getPlayer1())
                setOpponentResult(game.getPlayer2())
            }
            buttonReset.setOnClickListener {
                game.restart()
                setMyResult(game.getPlayer1())
                setOpponentResult(game.getPlayer2())
            }
        }
    }

    // Model 초기화
    private fun initGame() {
        game = Game { it.toList().shuffled().first() }
    }

    // Model을 View에 렌더링
    private fun setMyResult(player: Player) {
        binding.imageMyPick.setImageResource(convertPickToResId(player.pick))
        binding.textMyResult.text = convertGameResultToString(player.gameResult)
    }

    // Model을 View에 렌더링
    private fun setOpponentResult(player: Player) {
        binding.imageOpponentPick.setImageResource(convertPickToResId(player.pick))
        binding.textOpponentResult.text = convertGameResultToString(player.gameResult)
    }

    // Model을 View에 렌더링
    private fun convertPickToResId(pick: Pick?): Int {
        return when (pick) {
            Pick.ROCK -> R.drawable.rock
            Pick.PAPER -> R.drawable.paper
            Pick.SCISSORS -> R.drawable.scissors
            null -> 0
        }
    }

    // Model을 View에 렌더링
    private fun convertGameResultToString(gameResult: GameResult?): String {
        return when (gameResult) {
            GameResult.WIN -> "승리"
            GameResult.DRAW -> "무승부"
            GameResult.LOSE -> "패배"
            null -> ""
        }
    }
}