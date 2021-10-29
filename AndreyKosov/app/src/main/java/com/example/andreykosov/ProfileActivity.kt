package com.example.andreykosov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andreykosov.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val intentSignIn = Intent(this, SignInActivity::class.java)
        bindingClass.profileButtonLogout.setOnClickListener {
            startActivity(intentSignIn)
        }
    }
}
