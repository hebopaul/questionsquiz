package com.example.quizgame.di

import com.example.quizgame.Repository
import com.example.quizgame.api.QuestionsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class MainModule() {




    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(QuestionsApi.BASE_URL)
            .build()
    }


    @Provides
    @Singleton
    fun provideQuestionsApi(retrofit: Retrofit): QuestionsApi {
        return retrofit.create(QuestionsApi::class.java)
    }

}