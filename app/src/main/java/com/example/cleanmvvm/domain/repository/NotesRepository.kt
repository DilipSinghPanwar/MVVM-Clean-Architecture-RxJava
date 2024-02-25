package com.example.cleanmvvm.domain.repository

import com.example.cleanmvvm.domain.model.Note
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface NotesRepository {

    fun getNotes(): Observable<List<Note>>

    fun insertNote(note:Note): Completable

    fun deleteNote(note:Note): Completable

}