package com.example.cleanmvvm.data.localdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanmvvm.domain.model.Note
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note): Completable

    @Query("select * from note_table")
    fun getNotes(): Observable<List<Note>>

    @Delete
    fun deleteNote(note: Note): Completable
}