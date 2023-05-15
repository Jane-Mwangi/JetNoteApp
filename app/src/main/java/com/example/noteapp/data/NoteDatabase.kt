package com.example.noteapp.data

import Note
import androidx.room.*

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun noteDao():NoteDatabaseDao
}

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * from notes_tbl")
    fun getNotes():List<Note>


 @Query ("SELECT * from notes_tbl where id =:id")
 fun getNoteById(id:String):Note

 @Insert(onConflict = OnConflictStrategy.REPLACE)
 fun Insert(note: Note)

 @Update(onConflict = OnConflictStrategy.REPLACE)
 fun Update(note: Note)

 @Query("DELETE from notes_tbl")
 fun deleteAll()

 @Delete
 fun deleteNote(note: Note)
}
