package com.example.kidseducation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kidseducation.R
import com.example.kidseducation.databinding.FragmentMenuBinding
import com.example.kidseducation.databinding.FragmentOnBoardingFirstBinding
import com.example.kidseducation.utilits.replaceFragmentMain

class MenuFragment : Fragment() {
    private var _binding : FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.blockNumber.setOnClickListener { replaceFragmentMain(NumberFragment()) }

        binding.blockReading.setOnClickListener { replaceFragmentMain(ReadingFragment()) }

        return binding.root
    }
}