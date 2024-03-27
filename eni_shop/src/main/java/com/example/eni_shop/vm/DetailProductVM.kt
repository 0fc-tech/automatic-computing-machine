package com.example.eni_shop.vm

import androidx.lifecycle.ViewModel
import com.example.eni_shop.model.Product
import com.example.eni_shop.model.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailProductVM(
    val repository: ProductRepository = ProductRepository) : ViewModel() {
    private val _productState = MutableStateFlow<Product?>(null)
    val productState : StateFlow<Product?> = _productState
    fun fetchProductByIndex(index: Int){
        _productState.value = repository.products[index]
    }
}









