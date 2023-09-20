package com.example.kidseducation.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kidseducation.R
import com.example.kidseducation.databinding.FragmentNumberBinding
import com.example.kidseducation.utilits.replaceFragmentMain
import com.example.kidseducation.viewmodel.NumberViewModel

class NumberFragment : Fragment() {
    private var _binding : FragmentNumberBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : NumberViewModel
    private var position = 0
    private var checkClick = true
    private var listSize = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNumberBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(NumberViewModel::class.java)

        observeData()

        binding.ivArrow.setOnClickListener { replaceFragmentMain(MenuFragment()) }

        return binding.root
    }

    private fun observeData() {
        viewModel.getResultNumber().observe(viewLifecycleOwner, Observer {
            binding.iconNumber.setImageResource(it.get(position).icon)
            binding.tvAnswer1.setText(it.get(position).option.get(0).option_a)
            binding.tvAnswer2.setText(it.get(position).option.get(0).option_b)
            listSize = it.size

            optionsClick(it.get(position).option.get(0).option_a, it.get(position).option.get(0).option_b,
            it.get(position).positionAnswer, it.get(position).option.get(0).option_a_position, it.get(position).option.get(0).option_b_position)

        })
    }

    private fun optionsClick(
        optionA: Int,
        optionB: Int,
        positionAnswer: Int,
        optionAPosition: Int,
        optionBPosition: Int
    ) {
        binding.btAnswer1.setOnClickListener {
            if (checkClick){
                checkClick = false
                binding.tvAnswer1.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
        }

        binding.btAnswer2.setOnClickListener {
            if (checkClick){
                checkClick = false
                binding.tvAnswer2.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
        }

        onClick()
    }

    private fun onClick() {
        binding.btNext.setOnClickListener {
            position++
            checkClick = true
            if (listSize > position){
                observeData()
            } else {
                replaceFragmentMain(MenuFragment())
            }
        }
    }
}