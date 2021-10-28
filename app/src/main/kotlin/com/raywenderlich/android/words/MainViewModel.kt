package com.raywenderlich.android.words

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.raywenderlich.android.words.data.words.RandomWords
import com.raywenderlich.android.words.data.words.Word
import kotlinx.coroutines.runBlocking

/**
 * Created by Aluoch on 25/10/2021.
 */

// Defining the ViewModel as an AndroidViewModel associated with application instance.
//Application instance is used to inject components
class MainViewModel(application: Application) : AndroidViewModel(application) {
    // Returns the values in WordlistUi
    private val wordRepository =
        getApplication<WordsApp>().wordRepository
    val words: List<Word> = runBlocking { wordRepository.allWords() }
    //val words: List<Word> = RandomWords.map { Word(it) }

}


