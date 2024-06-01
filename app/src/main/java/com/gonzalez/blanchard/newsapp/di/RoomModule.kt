package com.gonzalez.blanchard.newsapp.di

import android.content.Context
import androidx.room.Room
import com.gonzalez.blanchard.newsapp.data.datasource.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    private val databaseName = "NewsDB"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        databaseName
    ).fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .addMigrations()
        .build()

    @Singleton
    @Provides
    fun provideNewsDao(db: AppDatabase) = db.getNewsDao()


}