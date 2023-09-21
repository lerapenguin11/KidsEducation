package com.example.kidseducation.presentation

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kidseducation.business.datebase.AppDatabase
import com.example.kidseducation.business.repos.ResultRepository
import com.example.kidseducation.databinding.FragmentResultBinding
import com.example.kidseducation.presentation.adapter.ResultAdapter
import com.example.kidseducation.utilits.replaceFragmentMain
import com.example.kidseducation.viewmodel.ReadingViewModel
import com.example.kidseducation.viewmodel.ResultViewModel
import com.example.kidseducation.viewmodel.ResultViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetBehavior


class ResultFragment : Fragment() {
    private var _binding : FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val adapter = ResultAdapter()
    private lateinit var resultViewModel : ResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResultBinding.inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application
        val dao = AppDatabase.getDatabase(application).resultDao()
        val repository = ResultRepository(dao)
        val viewModelFactoryNews = ResultViewModelFactory(repository)

        resultViewModel = ViewModelProvider(this, viewModelFactoryNews).get(ResultViewModel::class.java)

        val sheetBehavior = BottomSheetBehavior.from(binding.bottomSheet)

        observeData()

        binding.bottomSheetButton.setOnClickListener(View.OnClickListener {
            if (sheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                binding.icArrow.setImageResource(com.example.kidseducation.R.drawable.ic_arrow_top)
                sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                binding.icArrow.setImageResource(com.example.kidseducation.R.drawable.ic_arrow_bottom)
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        })

        binding.icClose.setOnClickListener {
            deleteResult()
            replaceFragmentMain(MenuFragment())
        }

        return binding.root
    }

    private fun observeData() {
        binding.rvResult.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvResult.adapter = adapter

        resultViewModel.allResult.observe(viewLifecycleOwner, Observer {
            adapter.setItem(it)
        })
    }

    private fun deleteResult() {
        resultViewModel.allResult.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                resultViewModel.deleteResult(it)
            }
        })
    }
}