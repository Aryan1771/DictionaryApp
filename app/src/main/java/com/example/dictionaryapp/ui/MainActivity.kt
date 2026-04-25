package com.example.dictionaryapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.dictionaryapp.R
import com.example.dictionaryapp.database.AppDatabase
import com.example.dictionaryapp.database.HistoryEntity
import com.example.dictionaryapp.utils.TTSManager
import com.example.dictionaryapp.viewmodel.SearchViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchViewModel
    private lateinit var tts: TTSManager
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        tts = TTSManager(this)
        db = AppDatabase.getDB(this)

        val input = findViewById<EditText>(R.id.inputWord)
        val result = findViewById<TextView>(R.id.resultText)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val speakBtn = findViewById<Button>(R.id.speakBtn)
        val historyBtn = findViewById<Button>(R.id.historyBtn)
        val loading = findViewById<ProgressBar>(R.id.loadingBar)
        val spinner = findViewById<Spinner>(R.id.languageSpinner)

        // Language Dropdown
        val languageMap = mapOf(
            "English" to "en",
            "Hindi" to "hi",
            "French" to "fr",
            "Spanish" to "es",
            "German" to "de"
        )
        val displayLanguages = languageMap.keys.toList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, displayLanguages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        searchBtn.setOnClickListener {
            val word = input.text.toString()
            val selectedDisplayName = spinner.selectedItem.toString()
            val langCode = languageMap[selectedDisplayName] ?: "en"

            viewModel.search(word, langCode)

            // Save to history
            lifecycleScope.launch {
                db.historyDao().insert(HistoryEntity(word = word))
            }
        }

        speakBtn.setOnClickListener {
            tts.speak(input.text.toString())
        }

        historyBtn.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        viewModel.result.observe(this) {
            result.text = it
        }

        viewModel.isLoading.observe(this) {
            loading.visibility = if (it) View.VISIBLE else View.GONE
        }
    }
}
