package com.example.cryptowallet

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptowallet.databinding.ActivityProfileUpdateBinding
import com.example.cryptowallet.fragments.MainFragment
import java.io.FileNotFoundException

class ProfileUpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileUpdateBinding
    private val pickImage = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButtonProfileUpdate.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            @Suppress("DEPRECATION")
            startActivityForResult(photoPickerIntent, pickImage)
        }
        binding.materialButtonProfileUpdate.setOnClickListener {
            if(binding.textInputEditTextProfileUpdateFirstName.error.isNullOrBlank() &&
                binding.textInputEditTextProfileUpdateLastName.error.isNullOrBlank()
            ) {
                val intentMain = Intent(this@ProfileUpdateActivity, MainActivity::class.java)
                startActivity(intentMain)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent)
        when (requestCode) {
            pickImage -> if (resultCode == RESULT_OK) {
                try {
                    val imageUri = imageReturnedIntent!!.data
                    val imageStream = contentResolver.openInputStream(
                        imageUri!!
                    )
                    val selectedImage = BitmapFactory.decodeStream(imageStream)
                    binding.imageButtonProfileUpdate.setImageBitmap(selectedImage)
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
            }
        }
    }
}
