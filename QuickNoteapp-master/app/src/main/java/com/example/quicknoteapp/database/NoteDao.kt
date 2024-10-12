package com.example.quicknoteapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.quicknoteapp.model.Notes

@Dao
interface NoteDao {
//    Replace the existing data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // call from coroutine
    suspend fun insertNote(note:Notes)

    @Update
    suspend fun updateNote(note:Notes)

    @Delete
    suspend fun deleteNote(note: Notes)

    @Query("SELECT * FROM NOTES ORDER BY id DESC")
    fun getAllNotes():LiveData<List<Notes>>

    //If data is equal to noteTitle or noteDesc store them in Livedata containing list Notes entities
    @Query("SELECT * FROM NOTES WHERE noteTitle LIKE :query OR noteDesc LIKE:query")

    fun searchNote(query: String?):LiveData<List<Notes>>


}