package com.raywenderlich.android.words

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.raywenderlich.android.words.data.words.RandomWords
import com.raywenderlich.android.words.data.words.Word

/**
 * Created by Aluoch on 25/10/2021.
 */

// Defining the ViewModel as an AndroidViewModel associated with application instance.
//Application instance is sued to inject components
class MainViewModel(application: Application) : AndroidViewModel(application) {
    // Returns the values in WordlistUi
    val words: List<Word> = RandomWords.map { Word(it) }

}


