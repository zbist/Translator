package com.zbistapp.translator.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.zbistapp.translator.R
import com.zbistapp.translator.domain.entities.MainEntity
import com.zbistapp.translator.domain.entities.TranslationEntity

class TranslationAdapter : RecyclerView.Adapter<TranslationAdapter.TranslationHolder>() {

    var list = emptyList<MainEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TranslationHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.translation_item, parent, false)
        return TranslationHolder(view)
    }

    override fun onBindViewHolder(holder: TranslationHolder, position: Int) {
        with(holder) {
            mainText.text = list[position].text
            translationText.text = list[position].meanings[0].translation.text
        }
    }

    override fun getItemCount(): Int = list.size

    inner class TranslationHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mainText: MaterialTextView = itemView.findViewById(R.id.item_title_text_view)
        val translationText: MaterialTextView =
            itemView.findViewById(R.id.item_translation_text_view)
    }
}