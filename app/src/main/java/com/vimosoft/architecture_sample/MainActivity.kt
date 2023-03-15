package com.vimosoft.architecture_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    // View 초기화
    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}