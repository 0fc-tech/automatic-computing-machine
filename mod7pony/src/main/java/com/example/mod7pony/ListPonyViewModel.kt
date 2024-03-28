package com.example.mod7pony

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "ListPonyViewModel"
class ListPonyViewModel : ViewModel() {
    private val _listPonyState = MutableStateFlow<List<Bike>?>(null)
    val ponyState = _listPonyState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            PonyApiClient.client.getPony().enqueue(object : Callback<PonyResponse>{
                override fun onResponse(
                    call: Call<PonyResponse>,
                    response: Response<PonyResponse>
                ) {
                    if(response.isSuccessful) {
                       val listBikes : List<Bike>? = response.body()?.data?.bikes

                        _listPonyState.update { listBikes?.filter {
                                bike -> !bike.is_disabled && !bike.is_reserved}
                        }
                    }
                }

                override fun onFailure(call: Call<PonyResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: $call ${t.message}", )
                }
            })

        }
    }



}