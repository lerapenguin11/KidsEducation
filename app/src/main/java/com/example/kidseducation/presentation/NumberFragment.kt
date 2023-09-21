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
import com.example.kidseducation.business.datebase.AppDatabase
import com.example.kidseducation.business.repos.ResultRepository
import com.example.kidseducation.databinding.FragmentNumberBinding
import com.example.kidseducation.utilits.replaceFragmentMain
import com.example.kidseducation.viewmodel.NumberViewModel
import com.example.kidseducation.viewmodel.ResultViewModel
import com.example.kidseducation.viewmodel.ResultViewModelFactory

class NumberFragment : Fragment() {
    private var _binding : FragmentNumberBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : NumberViewModel
    private var position = 0
    private var checkClick = true
    private var listSize = 0
    private lateinit var resultViewModel : ResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNumberBinding.inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application
        val dao = AppDatabase.getDatabase(application).resultDao()
        val repository = ResultRepository(dao)
        val viewModelFactoryNews = ResultViewModelFactory(repository)

        resultViewModel = ViewModelProvider(this, viewModelFactoryNews).get(ResultViewModel::class.java)

        viewModel = ViewModelProvider(requireActivity()).get(NumberViewModel::class.java)

        observeData()

        binding.ivArrow.setOnClickListener {
            deleteResult()
            replaceFragmentMain(MenuFragment())
        }

        return binding.root
    }

    private fun deleteResult() {
        resultViewModel.allResult.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                resultViewModel.deleteResult(it)
            }
        })
    }

    private fun observeData() {
        viewModel.getResultNumber().observe(viewLifecycleOwner, Observer {
            binding.iconNumber.setImageResource(it.get(position).icon)
            binding.tvAnswer1.setText(it.get(position).option.get(0).option_a)
            binding.tvAnswer2.setText(it.get(position).option.get(0).option_b)
            listSize = it.size
            binding.tvLevel.text = "${getString(R.string.level)} ${it.get(position).id+1}"

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
                if (positionAnswer == optionAPosition){
                    checkPosition(position, optionA)
                }
            }
        }

        binding.btAnswer2.setOnClickListener {
            if (checkClick){
                checkClick = false
                binding.tvAnswer2.setTextColor(Color.parseColor("#FFFFFFFF"))
                if (positionAnswer == optionBPosition){
                    checkPosition(position, optionB)
                }
            }
        }

        onClick()
    }

    private fun checkPosition(position: Int, text : Int) {
        viewModel.getResultNumber().observe(viewLifecycleOwner, Observer {
            val result = com.example.kidseducation.business.datebase.Result(text = text,
                icon = it.get(position).icon)
            resultViewModel.insertResult(result)
        })
    }

    private fun onClick() {
        binding.btNext.setOnClickListener {
            position++
            checkClick = true
            if (listSize > position){
                binding.tvAnswer1.setTextColor(Color.parseColor("#FFD426"))
                binding.tvAnswer2.setTextColor(Color.parseColor("#4BA651"))
                observeData()
            } else {
                replaceFragmentMain(ResultFragment())
            }
        }
    }
}