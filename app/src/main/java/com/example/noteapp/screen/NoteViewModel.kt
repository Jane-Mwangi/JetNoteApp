package com.example.noteapp.screen

import Note
import androidx.lifecycle.ViewModel
import com.example.noteapp.data.NotesDataSource

class NoteViewModel: ViewModel() {
    private  var notelist = mutableListOf<Note>()
    init {
        notelist.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note){
        notelist.add(note)
    }
    fun removeNote(note: Note){
        notelist.remove(note)
    }

     fun getAllNotes():List<Note>{
         return notelist
     }



}