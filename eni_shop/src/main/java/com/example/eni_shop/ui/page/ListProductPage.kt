package com.example.eni_shop.ui.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.eni_shop.model.Product
import com.example.eni_shop.ui.theme.TPTheme
import com.example.eni_shop.ui.theme.Typography
import com.example.eni_shop.vm.ListProductVM


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListProductPage(onProductClicked : (index : Int) -> Unit,
                    vm : ListProductVM = viewModel()) {
    val state = vm.listProductState.collectAsState()
    Scaffold(
        topBar = {
            TopBarListProduct()
        }
    ){ innerPadding->
        Column(Modifier.padding(innerPadding)){
            FilterChipList()
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                ) {
                itemsIndexed(state.value){ index: Int, product ->
                    Column(
                        Modifier
                            .padding(8.dp)
                            .clickable { onProductClicked(index) }) {
                        Card{
                            AsyncImage(
                                model = product.imageUrl,
                                contentDescription = "C'est une image frère",
                                Modifier.padding(28.dp)
                            )
                        }
                        Text(product.name)
                        Text("${product.price}€", style = Typography.titleSmall)
                    }
                }
            }

        }
    }
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBarListProduct() {
    TopAppBar(
        title = { Text("ENI SHOP") },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            }
        }
    )
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun FilterChipList() {
    LazyRow {
        items(10) {
            FilterChip(selected = false,
                onClick = { /*TODO*/ },
                label = { Text(it.toString()) }
            )
        }
    }
}

@Preview
@Composable
fun ListProductTPagePreview(){
    TPTheme {
        Surface {
            //ListProductPage()
        }
    }
}
