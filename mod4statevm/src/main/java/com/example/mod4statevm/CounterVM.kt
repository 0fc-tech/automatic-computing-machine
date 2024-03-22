package com.example.mod4statevm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterVM : ViewModel(){
    private val _stateFlowCounter = MutableStateFlow(0)
    val stateFlowCounter :StateFlow<Int> = _stateFlowCounter
    fun inc() {_stateFlowCounter.value+=1}
    fun dec() {_stateFlowCounter.value-=1}
}