package com.example.eni_shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.eni_shop.ui.page.DetailProductPage
import com.example.eni_shop.ui.page.ListProductPage
import com.example.eni_shop.ui.theme.TPTheme

class ShopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHostShop()
                }
            }
        }
    }
}
const val LIST_PRODUCTS = "listProducts"
const val DETAIL_PRODUCT = "detailProduct"
@Composable
fun NavHostShop(
    navController : NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = LIST_PRODUCTS,
        //enterTransition = { slideInHorizontally () },
        //exitTransition = { slideOutHorizontally () }
    ){
        composable(LIST_PRODUCTS){
            ListProductPage(onProductClicked = {indexProduct->
                navController.navigate("$DETAIL_PRODUCT/$indexProduct")
            })
        }
        composable(
            "$DETAIL_PRODUCT/{productIndex}",
            arguments = listOf(
                navArgument("productIndex") { type = NavType.IntType }
            )){backStackEntry->
            val indexProduct = backStackEntry.arguments?.getInt("productIndex")
            if(indexProduct == null){
                Text("Produit Introuvable")
            }else DetailProductPage(indexProduct)
        }
    }
}






