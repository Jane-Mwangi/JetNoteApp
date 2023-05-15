package com.example.noteapp.repository

import Note
import com.example.noteapp.data.NoteDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao : NoteDatabaseDao) {
    suspend fun  addNote(note: Note) = noteDatabaseDao.Insert(note)
    suspend fun  updateNote(note: Note) = noteDatabaseDao.update(note)
    suspend fun  deleteNote(note: Note) = noteDatabaseDao.deleteNote(note)
    suspend fun  deleteAllNotes(note: Note) = noteDatabaseDao.Insert(note)
    suspend fun  gelAllNotes(): Flow<List<Note>> = noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}