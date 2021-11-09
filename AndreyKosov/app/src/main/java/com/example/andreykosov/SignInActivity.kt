package com.example.andreykosov

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andreykosov.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signInMaterialButton.setOnClickListener {
            val signInValidation = Validator(this)
            val emailValue = binding.signInEmailEditText.text.toString()
            val passwordValue = binding.signInPasswordEditText.text.toString()
            binding.signInEmailEditText.error = signInValidation.validateEmail(emailValue)
            binding.signInPasswordEditText.error = signInValidation.validatePassword(passwordValue)
            if (signInValidation.validateEmail(emailValue) == null && signInValidation.validatePassword(passwordValue) == null) {
                val intentProfile = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Name", emailValue)
                startActivity(intentProfile)
            }
        }
        binding.signInBottomTextClickable.setOnClickListener {
            val intentRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intentRegister)
        }
    }
}
