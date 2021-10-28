package com.example.andreykosov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andreykosov.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        val intentSignIn = Intent(this, SignInActivity::class.java)
        val intentProfile = Intent(this, ProfileActivity::class.java)



        bindingClass.registerBottomText.setOnClickListener {
            startActivity(intentSignIn)
        }

        bindingClass.registerButton.setOnClickListener{

            val emailValue = bindingClass.registerEmail.text.toString()
            val passwordValue = bindingClass.registerPassword.text.toString()

            val registerValidation = Validator()

            if(registerValidation.validation(emailValue, passwordValue)){
                startActivity(intentProfile)
            }
        }

    }
}