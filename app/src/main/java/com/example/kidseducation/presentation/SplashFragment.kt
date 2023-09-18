package com.example.kidseducation.presentation

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.kidseducation.R
import com.example.kidseducation.databinding.FragmentSplashBinding
import com.example.kidseducation.utilits.replaceFragmentMain

class SplashFragment : Fragment() {
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            makeBlur()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            //getCheck(code)
                                                    replaceFragmentMain(OnBoardingFirstFragment())
        }, 3000)

        return binding.root
    }

    @RequiresApi(31)
    private fun makeBlur() {
        val blurEffect = RenderEffect.createBlurEffect(10f, 15f, Shader.TileMode.MIRROR)
        binding.fonEllipse.setRenderEffect(blurEffect)
    }
}