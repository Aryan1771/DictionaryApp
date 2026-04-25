package com.example.dictionaryapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionaryapp.R
import com.example.dictionaryapp.database.HistoryEntity

class HistoryAdapter(
    private val list: MutableList<HistoryEntity>,
    private val onClick: (HistoryEntity) -> Unit,
    private val onDelete: (HistoryEntity) -> Unit
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val word: TextView = view.findViewById(R.id.wordText)
        val deleteBtn: ImageButton = view.findViewById(R.id.deleteBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.word.text = item.word

        holder.itemView.setOnClickListener {
            onClick(item)
        }

        holder.deleteBtn.setOnClickListener {
            onDelete(item)
        }
    }

    fun updateList(newList: List<HistoryEntity>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}