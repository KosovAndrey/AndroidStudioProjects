package com.example.andreykosov

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andreykosov.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registerBottomText.setOnClickListener {
            val intentSignIn = Intent(this, SignInActivity::class.java)
            startActivity(intentSignIn)
        }
        binding.registerButton.setOnClickListener {
            val emailValue = binding.registerEmailEditText.text.toString()
            val passwordValue = binding.registerPasswordEditText.text.toString()
            val registerValidation = Validator(this)
            if (registerValidation.validateEmail(emailValue) == null &&
                registerValidation.validatePassword(passwordValue) == null &&
                registerValidation.validateEqualPassword(passwordValue, passwordValue) == null) {
                val intentProfile = Intent(this, ProfileActivity::class.java)
                intent.putExtra("email", emailValue)
                startActivity(intentProfile)
            }
        }
    }
}
