package com.example.andreykosov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.andreykosov.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val intentRegister = Intent(this, RegisterActivity::class.java)
        val intentProfile = Intent(this, ProfileActivity::class.java)
        bindingClass.signInMaterialButton.setOnClickListener {
            val emailValue = bindingClass.signInEmail.text.toString()
            val passwordValue = bindingClass.signInPassword.text.toString()
            val signInValidation = Validator()
            when {
                signInValidation.validation(emailValue, passwordValue)
                    -> startActivity(intentProfile)
                (!(emailValue.contains("@") && emailValue.length >= 7) && passwordValue.length >= 8)
                    -> bindingClass.signInEmail.error = "Enter a valid email address"
                passwordValue.length < 8
                    -> bindingClass.signInPassword.error = "Password must contain at least 8 characters"
            }
        }
        bindingClass.signInBottomTextClickable.setOnClickListener {
            startActivity(intentRegister)
        }
    }
}
