package com.example.cleanmvvm.di

import android.app.Application
import androidx.room.Room
import com.example.cleanmvvm.data.localdb.NoteDatabase
import com.example.cleanmvvm.data.repositoryimpl.NotesRepositoryImpl
import com.example.cleanmvvm.domain.repository.NotesRepository
import com.example.cleanmvvm.domain.usecase.DeleteNote
import com.example.cleanmvvm.domain.usecase.GetNotes
import com.example.cleanmvvm.domain.usecase.InsertNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Provides
    @Singleton
    fun provideNoteDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(application, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NotesRepository {
        return NotesRepositoryImpl(noteDatabase.noteDao)
    }

    @Provides
    @Singleton
    fun provideGetNoteUseCase(notesRepository: NotesRepository): GetNotes {
        return GetNotes(notesRepository)
    }

    @Provides
    @Singleton
    fun provideInsertUseCase(notesRepository: NotesRepository): InsertNote {
        return InsertNote(notesRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteUseCase(notesRepository: NotesRepository): DeleteNote {
        return DeleteNote(notesRepository)
    }

}