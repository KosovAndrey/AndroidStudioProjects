package com.example.cryptowallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptowallet.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var window: Window = window
        @Suppress("DEPRECATION")
        window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        binding.materialButtonOnBoarding.setOnClickListener{
            val intentLogIn = Intent(this, LogInActivity::class.java)
            startActivity(intentLogIn)
        }
    }
}
