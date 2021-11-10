package com.raywenderlich.android.words.data.words.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Aluoch on 10/11/2021.
 */

// indicates that the interface is a Data Access Object
@Dao
interface WordDao {
    //using the @Query keyword, queryAll defines an sqlite query
    @Query("select * from word order by value ")
    fun queryAll(): List<LocalWord>

    //insert adds or updates words to the db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(words: List<LocalWord>)

    //count finds out if the table is empty
    @Query("select count(*) from word")
    suspend fun count(): Long
}