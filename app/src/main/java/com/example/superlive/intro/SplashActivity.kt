package com.example.superlive.intro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.window.SplashScreen
import androidx.appcompat.app.AppCompatActivity
import com.example.superlive.MainActivity
import com.example.superlive.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blinkAnim = AnimationUtils.loadAnimation(this, com.example.superlive.R.anim.blink_animation)

        binding.imageSplash.animation = blinkAnim

        goToHomeActivity()
    }
    private fun goToHomeActivity() {
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }
}