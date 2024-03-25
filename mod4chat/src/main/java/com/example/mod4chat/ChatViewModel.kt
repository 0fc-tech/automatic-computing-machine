package com.example.mod4chat

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChatViewModel: ViewModel() {
    private val _chatState = MutableStateFlow(emptyList<Message>())
    val chatState : StateFlow<List<Message>> = _chatState

    fun sendMessage(message : Message){
        _chatState.value += message
    }
}