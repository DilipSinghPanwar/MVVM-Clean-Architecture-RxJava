package com.example.cleanmvvm.presentation

import com.example.cleanmvvm.domain.model.Note

sealed class NotesState(val notes: List<Note>? = null, val message: String? = null) {
    data class NotesFetched(val notesList: List<Note>) : NotesState(notes = notesList)
    object NotesInserted : NotesState()
    object NotesDeleted : NotesState()
    data class Error(val errorMessage: String?) : NotesState(message = errorMessage)
}
