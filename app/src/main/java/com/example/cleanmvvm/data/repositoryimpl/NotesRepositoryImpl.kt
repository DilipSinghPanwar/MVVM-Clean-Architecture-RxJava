package com.example.cleanmvvm.data.repositoryimpl

import com.example.cleanmvvm.data.localdb.NoteDao
import com.example.cleanmvvm.domain.model.Note
import com.example.cleanmvvm.domain.repository.NotesRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class NotesRepositoryImpl(private val noteDao:NoteDao): NotesRepository {

    override fun getNotes(): Observable<List<Note>> {
        return noteDao.getNotes()
    }

    override fun insertNote(note: Note): Completable {
        return noteDao.insertNote(note)
    }

    override fun deleteNote(note: Note): Completable {
        return noteDao.deleteNote(note)
    }

}