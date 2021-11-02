package com.example.andreykosov

class Validator {
    fun validation(emailValue: String, passwordValue: String): Boolean {
        var validation = false
        if (emailValue.contains("@") && emailValue.length >= 7 && passwordValue.length >= 8) {
            validation = true
        }
        return validation
    }
}
