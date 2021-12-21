package com.example.cryptowallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.example.cryptowallet.databinding.ActivitySignInBinding
import com.example.cryptowallet.fragments.MainFragment

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var window: Window = window
        @Suppress("DEPRECATION")
        window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.materialButtonSignIn.setOnClickListener{
            val validation = Validator(this@SignInActivity)
            val email = binding.textInputEditTextSignInEmail.text.toString()
            val password = binding.textInputEditTextSignInPassword.text.toString()
            val passwordConfirm = binding.textInputEditTextSignInConfirmPassword.text.toString()
            binding.textInputLayoutSignInEmail.error =
                validation.validateEmail(email)
            binding.textInputLayoutSignInPassword.error =
                validation.validatePassword(password)
            binding.textInputLayoutSignInConfirmPassword.error =
                validation.validateEqualPassword(password, passwordConfirm)
            if (binding.textInputLayoutSignInEmail.error == null &&
                binding.textInputLayoutSignInPassword.error == null &&
                binding.textInputLayoutSignInConfirmPassword.error == null
            ) {
                val intentProfileUpdate = Intent(this, ProfileUpdateActivity::class.java)
                startActivity(intentProfileUpdate)
            }
        }
        binding.textViewSignInTopClickable.setOnClickListener {
            val emailValue = binding.textInputEditTextSignInEmail.text.toString()
            val intent = Intent(this@SignInActivity, MainFragment::class.java)
            intent.putExtra("Name", emailValue)
            val intentLogIn = Intent(this, LogInActivity::class.java)
            startActivity(intentLogIn)
        }
    }
}
