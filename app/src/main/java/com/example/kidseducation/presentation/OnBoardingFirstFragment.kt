package com.example.kidseducation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kidseducation.R
import com.example.kidseducation.databinding.FragmentOnBoardingFirstBinding
import com.example.kidseducation.databinding.FragmentSplashBinding
import com.example.kidseducation.utilits.replaceFragmentMain

class OnBoardingFirstFragment : Fragment() {
    private var _binding : FragmentOnBoardingFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnBoardingFirstBinding.inflate(inflater, container, false)

        binding.btNext.setOnClickListener { replaceFragmentMain(OnBoardingSecondFragment()) }

        return binding.root
    }
}