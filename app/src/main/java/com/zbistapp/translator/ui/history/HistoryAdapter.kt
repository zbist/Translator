package com.zbistapp.translator.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.zbistapp.translator.R
import com.zbistapp.translator.room.HistoryRoomEntity

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {

    var list = emptyList<HistoryRoomEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_item, parent, false)
        return HistoryHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        with(holder) {
            mainText.text = list[position].word
        }
    }

    override fun getItemCount(): Int = list.size

    inner class HistoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mainText: MaterialTextView = itemView.findViewById(R.id.item_title_text_view)
    }
}