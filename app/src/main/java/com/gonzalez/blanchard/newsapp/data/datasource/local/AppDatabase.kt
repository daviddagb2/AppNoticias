package com.gonzalez.blanchard.newsapp.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gonzalez.blanchard.newsapp.data.datasource.local.dao.NewsDao
import com.gonzalez.blanchard.newsapp.data.datasource.local.entities.NewsEntity

@Database(
    entities = [NewsEntity::class],
    version = 1,

)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

}