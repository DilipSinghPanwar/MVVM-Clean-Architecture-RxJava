package com.example.cleanmvvm.domain.usecase

import com.example.cleanmvvm.domain.model.Note
import com.example.cleanmvvm.domain.repository.NotesRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class InsertNote (private val notesRepository: NotesRepository) {
    operator fun invoke(note: Note) : Completable = notesRepository.insertNote(note)
}