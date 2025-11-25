package me.rohinee.todo.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.rohinee.todo.data.local.ToDoDao
import me.rohinee.todo.data.local.ToDoDatabase
import me.rohinee.todo.data.remote.ToDoApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.simple.com/v1/") // <-- TODO: Replace with your actual API URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideToDoApiService(retrofit: Retrofit): ToDoApiService =
        retrofit.create(ToDoApiService::class.java)

    @Provides
    @Singleton
    fun provideToDoDatabase(@ApplicationContext context: Context):
            ToDoDatabase = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        "todo_database"
    ).build()

    @Provides
    @Singleton
    fun provideTodoDao(database: ToDoDatabase): ToDoDao = database.toDoDao()

}