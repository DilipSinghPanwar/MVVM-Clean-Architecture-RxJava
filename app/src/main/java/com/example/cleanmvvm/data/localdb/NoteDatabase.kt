package com.example.cleanmvvm.data.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanmvvm.domain.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        var DATABASE_NAME = "my_notes"
    }
}