package com.example.cleanmvvm.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var viewModel: NoteViewModel
    private val viewModel: NoteViewModel by viewModels<NoteViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.viewModel = viewModel

        // new code
//        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        binding.lifecycleOwner = this
        observeNoteState()
    }

    private fun observeNoteState() {
        viewModel.notesState.observe(this) {
            when(it) {
                is NotesState.NotesFetched -> {
//                    noteAdapter.updateList(it.notes ?: listOf())
                }
                is NotesState.NotesInserted -> {
                    Snackbar
                        .make(binding.root, "Note Successfully Inserted", Snackbar.LENGTH_LONG).show()
                }
                is NotesState.NotesDeleted -> {
                    Snackbar
                        .make(binding.root, "Note Deleted", Snackbar.LENGTH_LONG).show()
                }
                is NotesState.Error -> {
                    Snackbar
                        .make(binding.root, it.message ?: "Error Occured", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

}