package com.example.cryptowallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptowallet.databinding.ActivityLogInBinding
import com.example.cryptowallet.fragments.MainFragment

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var window: Window = window
        @Suppress("DEPRECATION")
        window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewLogInTopClickable.setOnClickListener {
            val intentSignIn = Intent(this@LogInActivity, SignInActivity::class.java)
            startActivity(intentSignIn)
        }
        binding.materialButtonLogIn.setOnClickListener {
            val validation = Validator(this@LogInActivity)
            val emailValue = binding.textInputEditTextSignInEmail.text.toString()
            val passwordValue = binding.textInputEditTextSignInPassword.text.toString()
            binding.textInputLayoutLogInEmail.error = validation.validateEmail(emailValue)
            binding.textInputLayoutLogInPassword.error = validation.validatePassword(passwordValue)
            if (binding.textInputLayoutLogInEmail.error.isNullOrBlank() &&
                binding.textInputLayoutLogInPassword.error.isNullOrBlank()
            ) {
                val intent = Intent(this@LogInActivity, MainFragment::class.java)
                intent.putExtra("Name", emailValue)
                val intentPin= Intent(this@LogInActivity, PinActivity::class.java)
                startActivity(intentPin)
            }
        }
    }
}