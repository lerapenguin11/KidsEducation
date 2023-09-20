package com.example.kidseducation.presentation

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kidseducation.databinding.FragmentReadingBinding
import com.example.kidseducation.presentation.adapter.LetterAnswerAdapter
import com.example.kidseducation.presentation.adapter.LetterKeyAdapter
import com.example.kidseducation.presentation.adapter.listener.LetterListener
import com.example.kidseducation.utilits.makeBlur
import com.example.kidseducation.utilits.replaceFragmentMain
import com.example.kidseducation.viewmodel.ReadingViewModel

class ReadingFragment : Fragment(), LetterListener {
    private var _binding : FragmentReadingBinding? = null
    private val binding get() = _binding!!
    private var position = 0
    private lateinit var viewModel : ReadingViewModel
    private val adapter = LetterKeyAdapter(position, this)
    private val adapterAnswer = LetterAnswerAdapter(position, this)
    private var count : Int = 0
    private var countLetter = 0
    private var textAnswer : String = ""
    private var listSize = 0

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentReadingBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ReadingViewModel::class.java)

        makeBlur(binding.fonEllipse)
        observeData()
        onCkick()
        binding.ivArrow.setOnClickListener { replaceFragmentMain(MenuFragment()) }

        return binding.root
    }

    private fun onCkick() {
        binding.btNext.setOnClickListener {
            if (adapterAnswer.resultText(count).equals(textAnswer)){
                Toast.makeText(requireContext(), "Correct: ${adapterAnswer.resultText(count)}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Not correct: ${adapterAnswer.resultText(count)}", Toast.LENGTH_SHORT).show()
            }
            if (position < listSize){
                position++
                count = 0
                countLetter = 0
                observeData()
            } else{
                replaceFragmentMain(MenuFragment())
            }
        }
    }

    private fun observeData() {
        val layoutManager =  GridLayoutManager(requireContext(), 4)
        binding.rvLetter.layoutManager = layoutManager
        binding.rvLetter.adapter = adapter

        binding.rvAnswerLetter.adapter = adapterAnswer
        binding.rvAnswerLetter.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        viewModel.getResultEquipment().observe(viewLifecycleOwner, Observer {
            adapter.setItem(it.get(this.position).keys)
            binding.iconAnimals.setImageResource(it.get(this.position).icon)
            adapterAnswer.setItem(it.get(this.position).defualtText, it.get(this.position).keys)
            countLetter = it.get(this.position).countLetter
            textAnswer = getString(it.get(this.position).textAnswer)
            listSize = it.size
        })
    }

    override fun getLetter(key: String) {
        if (count!=countLetter){
            val editTextAdapter = binding.rvAnswerLetter.adapter as LetterAnswerAdapter
            editTextAdapter.addLetter(key, LetterAnswerAdapter.LetterAnswerViewHolder(requireView()), count)
            count++
        }
    }
}