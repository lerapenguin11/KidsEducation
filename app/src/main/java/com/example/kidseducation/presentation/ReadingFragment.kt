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
import com.example.kidseducation.R
import com.example.kidseducation.business.datebase.AppDatabase
import com.example.kidseducation.business.repos.ResultRepository
import com.example.kidseducation.databinding.FragmentReadingBinding
import com.example.kidseducation.presentation.adapter.LetterAnswerAdapter
import com.example.kidseducation.presentation.adapter.LetterKeyAdapter
import com.example.kidseducation.presentation.adapter.listener.LetterListener
import com.example.kidseducation.utilits.makeBlur
import com.example.kidseducation.utilits.replaceFragmentMain
import com.example.kidseducation.viewmodel.ReadingViewModel
import com.example.kidseducation.viewmodel.ResultViewModel
import com.example.kidseducation.viewmodel.ResultViewModelFactory

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
    private lateinit var resultViewModel : ResultViewModel

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentReadingBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ReadingViewModel::class.java)
        val application = requireNotNull(this.activity).application
        val dao = AppDatabase.getDatabase(application).resultDao()
        val repository = ResultRepository(dao)
        val viewModelFactoryNews = ResultViewModelFactory(repository)

        resultViewModel = ViewModelProvider(this, viewModelFactoryNews).get(ResultViewModel::class.java)

        makeBlur(binding.fonEllipse)
        observeData()
        onCkick()
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

    private fun onCkick() {
        binding.btNext.setOnClickListener {
            if (adapterAnswer.resultText(count).equals(textAnswer)){
                viewModel.getResultEquipment().observe(viewLifecycleOwner, Observer {
                    val result = com.example.kidseducation.business.datebase.Result(text = it.get(position).textAnswer,
                    icon = it.get(position).icon)

                    resultViewModel.insertResult(result)
                })
                Toast.makeText(requireContext(), "Correct: ${adapterAnswer.resultText(count)}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Not correct: ${adapterAnswer.resultText(count)}", Toast.LENGTH_SHORT).show()
            }
            position++
            if (position < listSize){
                count = 0
                countLetter = 0
                observeData()
            } else{
                replaceFragmentMain(ResultFragment())
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
            binding.tvLevel.text = "${getString(R.string.level)} ${it.get(position).id+1}"
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