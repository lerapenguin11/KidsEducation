package com.example.kidseducation.presentation

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.kidseducation.R
import com.example.kidseducation.databinding.FragmentOnBoardingFirstBinding
import com.example.kidseducation.databinding.FragmentOnBoardingSecondBinding
import com.example.kidseducation.utilits.makeBlur
import com.example.kidseducation.utilits.replaceFragmentMain

class OnBoardingSecondFragment : Fragment() {
    private var _binding : FragmentOnBoardingSecondBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnBoardingSecondBinding.inflate(inflater, container, false)

        makeBlur(binding.fonEllipse)
        binding.btNext.setOnClickListener { replaceFragmentMain(OnBoardingThirdFragment()) }

        return binding.root
    }
}