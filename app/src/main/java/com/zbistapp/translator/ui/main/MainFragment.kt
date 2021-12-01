package com.zbistapp.translator.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zbistapp.translator.App
import com.zbistapp.translator.R
import com.zbistapp.translator.data.NetworkRepoImpl
import com.zbistapp.translator.databinding.FragmentMainBinding
import com.zbistapp.translator.domain.entities.MainEntity

class MainFragment : Fragment(R.layout.fragment_main), MainContract.View {

    private val presenter: MainPresenter =
        MainPresenter(NetworkRepoImpl(App.INSTANCE.translationApi))
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private lateinit var adapter: TranslationAdapter

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.onViewAttach(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        with(binding) {
            searchLayout.setEndIconOnClickListener {
                presenter.onSearchClicked(inputEditText.text.toString())
            }

            inputEditText.setOnKeyListener { _, keyCode, _ ->
                when (keyCode) {
                    KeyEvent.KEYCODE_ENTER -> {
                        presenter.onSearchClicked(inputEditText.text.toString())
                        return@setOnKeyListener true
                    }
                    else -> {
                        return@setOnKeyListener false
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        adapter = TranslationAdapter()
        binding.translationsRecyclerView.adapter = adapter
    }

    override fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setTranslation(listOfTranslate: List<MainEntity>) {
        adapter.list = listOfTranslate
        adapter.notifyDataSetChanged()
    }

    override fun setError(t: Throwable) {
        Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
    }

    override fun onDetach() {
        super.onDetach()
        presenter.onViewDetach()
    }

}