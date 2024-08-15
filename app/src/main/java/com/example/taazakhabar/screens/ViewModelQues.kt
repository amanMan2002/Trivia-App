package com.example.taazakhabar.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taazakhabar.data.DataorException
import com.example.taazakhabar.model.QuestionsItem
import com.example.taazakhabar.repo.QuestionRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelQues @Inject constructor(private val repo: QuestionRepo) : ViewModel() {
    val data: MutableState<DataorException<ArrayList<QuestionsItem>,Boolean,Exception>> = mutableStateOf(DataorException(null,true,Exception("")))

    init {
        getAllQues()
    }
    private fun getAllQues(){
        viewModelScope.launch{
            data.value.loading=true
            data.value=repo.getAllQuestions()
            if (data.value.data.toString().isNotEmpty()) data.value.loading=false
        }
    }
    fun getTotalQuestionCount(): Int {
        return data.value.data?.toMutableList()?.size!!
    }
}