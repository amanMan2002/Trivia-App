package com.example.taazakhabar.repo

import com.example.taazakhabar.data.DataorException
import com.example.taazakhabar.model.QuestionsItem
import com.example.taazakhabar.network.QuestionAPI
import javax.inject.Inject

class QuestionRepo @Inject constructor(private val api: QuestionAPI) {
   private val listofQuestion= DataorException<ArrayList<QuestionsItem>,Boolean,Exception>()
   suspend fun getAllQuestions(): DataorException<ArrayList<QuestionsItem>,Boolean,Exception> {
      try {
         listofQuestion.loading = true
         listofQuestion.data = api.getAllQuestions()
         if (listofQuestion.data.toString().isNotEmpty()) listofQuestion.loading = false
      } catch (exception: Exception) {
         listofQuestion.exception = exception
      }
      return listofQuestion
   }
}