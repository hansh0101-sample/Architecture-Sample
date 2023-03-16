package com.vimosoft.architecture_sample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vimosoft.architecture_sample.R
import com.vimosoft.architecture_sample.databinding.ActivityMainBinding
import com.vimosoft.architecture_sample.model.Pick
import com.vimosoft.architecture_sample.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel

        initOnClickListener()
    }

    private fun initOnClickListener() {
        with(binding) {
            imageScissors.setOnClickListener {
                mainViewModel.setMyPick(Pick.SCISSORS)
            }
            imageRock.setOnClickListener {
                mainViewModel.setMyPick(Pick.ROCK)
            }
            imagePaper.setOnClickListener {
                mainViewModel.setMyPick(Pick.PAPER)
            }
            buttonReset.setOnClickListener {
                mainViewModel.restart()
            }
        }
    }
}