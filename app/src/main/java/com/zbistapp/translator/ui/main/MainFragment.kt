package com.zbistapp.translator.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zbistapp.translator.App
import com.zbistapp.translator.R
import com.zbistapp.translator.data.NetworkRepoImpl
import com.zbistapp.translator.databinding.FragmentMainBinding
import com.zbistapp.translator.utils.ViewModelFactory

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModelFactory = ViewModelFactory(NetworkRepoImpl(App.INSTANCE.translationApi))

    private val viewModel: MainViewModel by viewModels {
        viewModelFactory
    }
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
                viewModel.onSearchClicked(inputEditText.text.toString())
            }

            inputEditText.setOnKeyListener { _, keyCode, _ ->
                when (keyCode) {
                    KeyEvent.KEYCODE_ENTER -> {
                        viewModel.onSearchClicked(inputEditText.text.toString())
                        return@setOnKeyListener true
                    }
                    else -> {
                        return@setOnKeyListener false
                    }
                }
            }
        }

        viewModel.isLoadingLiveData.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        viewModel.translationLiveData.observe(viewLifecycleOwner) {
            adapter.list = it
            adapter.notifyDataSetChanged()
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        adapter = TranslationAdapter()
        binding.translationsRecyclerView.adapter = adapter
    }
}