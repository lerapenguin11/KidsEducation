package com.example.kidseducation.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidseducation.R
import com.example.kidseducation.databinding.ActivityMainBinding
import com.example.kidseducation.utilits.APP_ACTIVITY
import com.example.kidseducation.utilits.replaceFragmentMain
import com.example.kidseducation.utilits.setStatusBarGradiantMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP_ACTIVITY = this
        setContentView(binding.root)
        setStatusBarGradiantMain(this)
        replaceFragmentMain(SplashFragment())
    }
}