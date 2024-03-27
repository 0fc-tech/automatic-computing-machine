package com.example.eni_shop.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.eni_shop.model.Product
import com.example.eni_shop.ui.theme.TPTheme
import com.example.eni_shop.ui.theme.Typography
import com.example.eni_shop.vm.DetailProductVM

@Composable
fun DetailProductPage(indexProduct : Int,
                      vm: DetailProductVM = viewModel()) {
    vm.fetchProductByIndex(indexProduct)
    val state = vm.productState.collectAsState()
    Scaffold {innerPadding->
        if (state.value == null)
            CircularProgressIndicator()
        else
            PhoneSpecWidget(
                modifier = Modifier.padding(innerPadding),
                state.value!!
        )
    }
}
@Composable
fun PhoneSpecWidget(modifier : Modifier, product : Product) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(product.name,
            style = Typography.titleLarge)
        Text("${product.price}€",style = Typography.titleSmall)
        Text("ou 400€/mois")
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "",
            Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .background(Color(232, 245, 254, 255))
                .height(280.dp))
        Text("Description",
            style = Typography.headlineSmall)
        Text(product.category)
        Text("Caractéristiques",
            style = Typography.headlineSmall)
        Text("Processeur")
        Text("  19 coeurs")
        Text("  125AI Threads")
        Text("GPU")
        Text(" 256 coeurs")
        Text(" 12 AI")
        Text("Ecran")
        Text("OLED")

        //ICI finir
    }
}

@Preview
@Composable
private fun PhoneSpecWidgetPreview() {
    TPTheme {
        Surface{
            Scaffold { innerPadding ->
                PhoneSpecWidget(Modifier.padding(innerPadding), Product("","",0f,""))
            }
        }

    }
}

