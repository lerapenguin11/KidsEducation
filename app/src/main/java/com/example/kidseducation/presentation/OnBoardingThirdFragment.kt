package com.example.kidseducation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kidseducation.R
import com.example.kidseducation.databinding.FragmentOnBoardingSecondBinding
import com.example.kidseducation.databinding.FragmentOnBoardingThirdBinding
import com.example.kidseducation.utilits.replaceFragmentMain

class OnBoardingThirdFragment : Fragment() {
    private var _binding : FragmentOnBoardingThirdBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnBoardingThirdBinding.inflate(inflater, container, false)

        binding.btNext.setOnClickListener { replaceFragmentMain(MenuFragment()) }

        return binding.root
    }
}