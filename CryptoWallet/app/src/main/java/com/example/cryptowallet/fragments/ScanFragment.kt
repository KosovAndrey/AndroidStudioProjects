package com.example.cryptowallet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cryptowallet.databinding.FragmentScanBinding
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog




class ScanFragment : Fragment() {
    private lateinit var binding: FragmentScanBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScanBinding.inflate(inflater, container, false)
//        binding.buttonScanFragment.setOnClickListener {
//            val intentIntegrator = IntentIntegrator(this@ScanFragment)
//            intentIntegrator.setPrompt("For flash use volume up")
//            intentIntegrator.setBeepEnabled(true)
//            intentIntegrator.setOrientationLocked(true)
//            intentIntegrator.setCaptureActivity(Capture::class.java)
//            intentIntegrator.initiateScan()
//        }
        return binding.root
    }
}