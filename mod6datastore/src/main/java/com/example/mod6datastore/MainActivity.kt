package com.example.mod6datastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6datastore.ui.theme.TPTheme
import com.example.mod6datastore.ui.theme.Typography
import kotlinx.coroutines.flow.StateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SettingsPage()
                }
            }
        }
    }
}

@Composable
fun SettingsPage(vm : SettingsViewModel = viewModel(factory = SettingsViewModel.Factory)) {
    Scaffold(contentWindowInsets = WindowInsets(32,32,32,32)) { innerPadding->
        Column(verticalArrangement =Arrangement.spacedBy(8.dp),
        modifier=Modifier.padding(innerPadding)) {
            CardSetting("Adresse 1 ",
                        vm.adresse1StateFlow,
                        onSaveSetting = {vm.saveAdresse1(it)})
            CardSetting("Adresse 2",
                        vm.adresse2StateFlow,
                        onSaveSetting = {vm.saveAdresse2(it)})
            CardSetting("Code Entreprise",
                        vm.codeEntrepriseStateFlow,
                        onSaveSetting = {vm.saveCodeEntreprise(it)})
            CardSetting("ID Carte réduction",
                        vm.carteReductionStateFlow,
                        onSaveSetting = {vm.saveCarteReduction(it)})
        }
    }
}

@Composable
private fun CardSetting(titre : String,
                        settingValueVM : StateFlow<String?>,
                        onSaveSetting : (String)->Unit) {
    var uiState by remember {mutableStateOf("") }
    uiState = settingValueVM.collectAsState().value ?: ""
    Card {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            Text(titre, style = Typography.titleMedium)
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState,
                onValueChange = {uiState = it},
                trailingIcon = {
                    IconButton(onClick = { onSaveSetting(uiState) }) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Valider"
                        )
                    }
                }
            )
        }
    }
}








