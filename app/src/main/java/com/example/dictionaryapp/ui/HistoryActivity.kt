package com.example.dictionaryapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionaryapp.R
import com.example.dictionaryapp.database.AppDatabase
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val recycler = findViewById<RecyclerView>(R.id.historyRecycler)

        db = AppDatabase.getDB(this)

        adapter = HistoryAdapter(mutableListOf(),
            onClick = {},
            onDelete = { entity ->
                lifecycleScope.launch {
                    db.historyDao().delete(entity)
                }
            })

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        db.historyDao().getAll().observe(this) {
            adapter.updateList(it)
        }
    }
}
