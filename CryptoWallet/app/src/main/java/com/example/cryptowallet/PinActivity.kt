package com.example.cryptowallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptowallet.databinding.ActivityLogInBinding
import com.example.cryptowallet.databinding.ActivityPinBinding
import com.kevalpatel.passcodeview.PinView
import com.kevalpatel.passcodeview.authenticator.PasscodeViewPinAuthenticator
import com.kevalpatel.passcodeview.indicators.CircleIndicator
import com.kevalpatel.passcodeview.interfaces.AuthenticationListener
import com.kevalpatel.passcodeview.keys.KeyNamesBuilder
import com.kevalpatel.passcodeview.keys.RoundKey

class PinActivity : AppCompatActivity() {
    private var mPinView: PinView? = null
    private lateinit var binding: ActivityPinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var window: Window = window
        @Suppress("DEPRECATION")
        window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        binding = ActivityPinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mPinView = binding.pinViewPinActivity
        val correctPattern = intArrayOf(1, 2, 3, 4)
        mPinView!!.pinAuthenticator = PasscodeViewPinAuthenticator(correctPattern)
        mPinView!!.setKey(
            RoundKey.Builder(mPinView!!)
                .setKeyPadding(R.dimen.key_padding)
                .setKeyStrokeColorResource(R.color.white)
                .setKeyStrokeWidth(R.dimen.key_stroke_width)
                .setKeyTextColorResource(R.color.white)
                .setKeyTextSize(R.dimen.key_text_size)
        )
        mPinView!!.setIndicator(
            CircleIndicator.Builder(mPinView!!)
                .setIndicatorRadius(R.dimen.indicator_radius)
                .setIndicatorFilledColorResource(R.color.white)
                .setIndicatorStrokeColorResource(R.color.white)
                .setIndicatorStrokeWidth(R.dimen.indicator_stroke_width)
        )
        mPinView!!.pinLength = PinView.DYNAMIC_PIN_LENGTH
        mPinView!!.setKeyNames(
            KeyNamesBuilder()
                .setKeyOne(this, R.string.key_1)
                .setKeyTwo(this, R.string.key_2)
                .setKeyThree(this, R.string.key_3)
                .setKeyFour(this, R.string.key_4)
                .setKeyFive(this, R.string.key_5)
                .setKeySix(this, R.string.key_6)
                .setKeySeven(this, R.string.key_7)
                .setKeyEight(this, R.string.key_8)
                .setKeyNine(this, R.string.key_9)
                .setKeyZero(this, R.string.key_0)
        )
        mPinView!!.title = "Enter the PIN"
        mPinView!!.setAuthenticationListener(object : AuthenticationListener {
            override fun onAuthenticationSuccessful() {
                Toast.makeText(applicationContext, "Correct PIN", Toast.LENGTH_SHORT).show()
                val intentMain = Intent(this@PinActivity, MainActivity::class.java)
                startActivity(intentMain)
            }
            override fun onAuthenticationFailed() {
                Toast.makeText(applicationContext, "Wrong PIN", Toast.LENGTH_SHORT).show()
            }
        })
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntArray(ARG_CURRENT_PIN, mPinView!!.currentTypedPin)
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mPinView!!.currentTypedPin = savedInstanceState.getIntArray(ARG_CURRENT_PIN)
    }
    companion object {
        private const val ARG_CURRENT_PIN = "current_pin"
    }
}
