package com.example.cleanmvvm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var content: String
)
