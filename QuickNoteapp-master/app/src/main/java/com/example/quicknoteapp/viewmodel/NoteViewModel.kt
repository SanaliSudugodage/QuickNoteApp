package com.example.quicknoteapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.quicknoteapp.model.Notes
import com.example.quicknoteapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app:Application, private val noteRepository: NoteRepository):AndroidViewModel(app) {

    //prevent memeory loss
    fun addNote(notes: Notes) =
        viewModelScope.launch {
            noteRepository.insertNote(notes)
        }

    fun deleteNote(notes: Notes) =
        viewModelScope.launch {
            noteRepository.deleteNote(notes)
        }

    fun updateNote(notes: Notes) =
        viewModelScope.launch {
            noteRepository.updateNote(notes)
        }

    fun getAllNotes() = noteRepository.getAllNotes()

    fun searchNote(query:String?) =
        noteRepository.searchNote(query)

}