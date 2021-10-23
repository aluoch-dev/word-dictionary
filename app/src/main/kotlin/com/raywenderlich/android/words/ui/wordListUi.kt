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
import com.raywenderlich.android.words.data.words.RandomWords
import com.raywenderlich.android.words.data.words.Word
import com.raywenderlich.android.words.ui.bars.MainTopBar

/**
 * Created by Aluoch on 23/10/2021.
 */

@Composable
fun WordListUi(){
    Scaffold(
        topBar = { MainTopBar()},
        content = {
            WordsContent(
                words = RandomWords.map { Word(it) },       // 1
                onSelected = { word -> Log.e("WordsContent",
                    "Selected: $word") } // 2
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
    words: List<Word>,
    onSelected: (Word) -> Unit,
) {
    LazyColumn {
        items(words) { word ->
            WordColumnItem(
                word = word
            ) { onSelected(word) }
        }
    }
}

