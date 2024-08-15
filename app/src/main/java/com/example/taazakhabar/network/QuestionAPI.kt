package com.example.taazakhabar.network

import com.example.taazakhabar.model.Questions
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {
    @GET("world.json")
    suspend fun getAllQuestions(): Questions

}