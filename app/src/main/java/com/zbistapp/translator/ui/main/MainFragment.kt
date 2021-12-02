package com.zbistapp.translator.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zbistapp.translator.R
import com.zbistapp.translator.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private val mainViewModel: MainViewModel by viewModel()
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private lateinit var adapter: TranslationAdapter

    companion object {
        fun newInstance() = MainFragment()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        with(binding) {
            searchLayout.setEndIconOnClickListener {
                mainViewModel.onSearchClicked(inputEditText.text.toString())
            }

            inputEditText.setOnKeyListener { _, keyCode, _ ->
                when (keyCode) {
                    KeyEvent.KEYCODE_ENTER -> {
                        mainViewModel.onSearchClicked(inputEditText.text.toString())
                        return@setOnKeyListener true
                    }
                    else -> {
                        return@setOnKeyListener false
                    }
                }
            }
        }

        mainViewModel.isLoadingLiveData.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        mainViewModel.translationLiveData.observe(viewLifecycleOwner) {
            adapter.list = it
            adapter.notifyDataSetChanged()
        }

        mainViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        adapter = TranslationAdapter()
        binding.translationsRecyclerView.adapter = adapter
    }
}