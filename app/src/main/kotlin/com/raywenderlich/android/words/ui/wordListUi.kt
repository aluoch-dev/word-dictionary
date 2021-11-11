package com.raywenderlich.android.words.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.raywenderlich.android.words.data.words.RandomWords
import com.raywenderlich.android.words.data.words.Word
import com.raywenderlich.android.words.ui.bars.MainTopBar
import kotlinx.coroutines.flow.Flow

/**
 * Created by Aluoch on 23/10/2021.
 */

@Composable
fun WordListUi(words: Flow<PagingData<Word>>){// Adding a new parameter to WordListUi, words which is a List of the defined Word data class
    Scaffold(
        topBar = { MainTopBar()},
        content = {
            WordsContent(
                words = words,       // Passes the list of words to WordsContent. Note that word generation is now in the MainViewModel
                onSelected = { word -> Log.e("WordsContent",
                    "Selected: $word") }
            )

        }
    )
}

//shows a word as a list item
@Composable
private fun WordColumnItem(
    word: Word,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier.clickable { onClick() },
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = word.value,
        )
    }
}


//displays a list of words
@Composable
private fun WordsContent(
    words: Flow<PagingData<Word>>,
    onSelected: (Word) -> Unit,
) {
    val items: LazyPagingItems<Word> = words.collectAsLazyPagingItems()
    LazyColumn {
        items(items = items) { word ->
            if (word != null) {
                WordColumnItem(
                    word = word
                ) { onSelected(word) }
            }
        }
    }
}

