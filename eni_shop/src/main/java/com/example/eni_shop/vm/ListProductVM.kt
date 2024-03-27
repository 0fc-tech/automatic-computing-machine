package com.example.eni_shop.vm

import androidx.lifecycle.ViewModel
import com.example.eni_shop.model.Product
import com.example.eni_shop.model.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListProductVM(
    val repository: ProductRepository = ProductRepository) : ViewModel() {
        private val _listProductState = MutableStateFlow<List<Product>>(emptyList())
        val listProductState :StateFlow<List<Product>> = _listProductState
    init {
        _listProductState.value = repository.products
    }
}