package com.example.andreykosov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.andreykosov.databinding.ActivityGetstartedBinding


class GetStartedActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityGetstartedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getstarted)
        bindingClass = ActivityGetstartedBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        bindingClass.getStartedButton.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}