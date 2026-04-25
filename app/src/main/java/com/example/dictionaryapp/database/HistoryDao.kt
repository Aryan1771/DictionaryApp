package com.example.dictionaryapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HistoryDao {

    @Insert
    suspend fun insert(entity: HistoryEntity)

    @Query("SELECT * FROM history ORDER BY id DESC")
    fun getAll(): LiveData<List<HistoryEntity>>

    @Delete
    suspend fun delete(entity: HistoryEntity)
}
