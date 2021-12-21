package com.example.cryptowallet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import com.example.cryptowallet.R
import com.example.cryptowallet.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val name = activity?.intent?.extras?.getString("Name")
        binding.textViewMainFragmentGreeting.text = getString(R.string.profile_greeting, name)
        return binding.root
    }
}