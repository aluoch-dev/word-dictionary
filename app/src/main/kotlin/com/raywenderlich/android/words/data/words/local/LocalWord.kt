package com.raywenderlich.android.words.data.words.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Aluoch on 10/11/2021.
 */

@Entity(tableName = "word")
data class LocalWord(
    @PrimaryKey val value: String,
)
