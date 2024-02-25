package com.example.cleanmvvm.domain.usecase

import com.example.cleanmvvm.domain.model.Note
import com.example.cleanmvvm.domain.repository.NotesRepository
import io.reactivex.rxjava3.core.Observable

class GetNotes (private val notesRepository: NotesRepository) {
    operator fun invoke() : Observable<List<Note>> = notesRepository.getNotes()
}