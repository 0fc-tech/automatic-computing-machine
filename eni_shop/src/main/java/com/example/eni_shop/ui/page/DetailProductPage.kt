package com.example.eni_shop.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.eni_shop.ui.theme.TPTheme
import com.example.eni_shop.ui.theme.Typography

@Composable
fun DetailProductPage(indexProduct : Int) {
    Scaffold {innerPadding->
        PhoneSpecWidget(modifier = Modifier.padding(innerPadding))
    }
}
@Composable
fun PhoneSpecWidget(modifier : Modifier) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Apple iphone Pro Max Edition Gold Billionaire",
            style = Typography.titleLarge)
        Text("2800€",style = Typography.titleSmall)
        Text("ou 400€/mois")
        AsyncImage(
            model = "https://media2.gsm55.com/media/device/4932/4932.png",
            contentDescription = "",
            Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .background(Color(232, 245, 254, 255))
                .height(280.dp))
        Text("Description",
            style = Typography.headlineSmall)
        Text("Ce téléphone sdf dsf zehf i sd b fub ubusdb vsuidgvvbsuib sduc sdb ui")
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
                PhoneSpecWidget(Modifier.padding(innerPadding))
            }
        }

    }
}

