package com.example.taazakhabar.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.taazakhabar.component.Questions

@Composable
fun TriviaHome(viewModel: ViewModelQues= hiltViewModel()){
    Questions(viewModel)
}