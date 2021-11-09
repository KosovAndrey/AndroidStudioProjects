package com.example.andreykosov

import android.content.Context

class Validator(private val context: Context) {
    fun validateEmail(emailValue: String): String? {
        return when {
            emailValue.length <= 6 -> context.getString(R.string.error_email_length)
            !(emailValue.contains("@")) -> context.getString(R.string.error_email_sign)
            else -> null
        }
    }
    fun validatePassword(passwordValue: String): String? {
        return when {
            passwordValue.length <= 7 -> context.getString(R.string.error_password_length)
            else -> null
        }
    }
    fun validateEqualPassword(passwordValue: String, passwordConfirmValue: String): String? {
        return when {
            passwordValue != passwordConfirmValue -> context.getString(R.string.error_password_different)
            else -> null
        }
    }
}
