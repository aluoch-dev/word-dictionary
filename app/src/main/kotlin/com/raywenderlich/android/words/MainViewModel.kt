package com.raywenderlich.android.words

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.raywenderlich.android.words.data.words.RandomWords
import com.raywenderlich.android.words.data.words.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Aluoch on 25/10/2021.
 */

// Defining the ViewModel as an AndroidViewModel associated with application instance.
//Application instance is used to inject components
class MainViewModel(application: Application) : AndroidViewModel(application) {
    //loading state
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading


    // Returns the values in WordlistUi
    private val wordRepository =
        getApplication<WordsApp>().wordRepository

    private val _words = MutableStateFlow(emptyFlow<PagingData<Word>>())// creates an internal mutableState which hosts the list of words.
    val words: StateFlow<Flow<PagingData<Word>>> = _words

    //loads the lst of words
    fun load() = effect {
        _isLoading.value = true
        _words.value = wordRepository.allWords()
        _isLoading.value = false
    }

   private fun effect(block: suspend () -> Unit){
       viewModelScope.launch(Dispatchers.IO) { block() }
   }

}


