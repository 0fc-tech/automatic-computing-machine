package com.example.mod7pony

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod7pony.ui.theme.TPTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Battery0Bar
import androidx.compose.material.icons.filled.Battery1Bar
import androidx.compose.material.icons.filled.Battery2Bar
import androidx.compose.material.icons.filled.Battery3Bar
import androidx.compose.material.icons.filled.Battery4Bar
import androidx.compose.material.icons.filled.Battery5Bar
import androidx.compose.material.icons.filled.Battery6Bar
import androidx.compose.material.icons.filled.BatteryAlert
import androidx.compose.material.icons.filled.BatteryFull
import androidx.compose.material.icons.filled.ElectricScooter
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.dp

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
                   ListBikes()
                }
            }
        }
    }
}

@Composable
fun ListBikes(vm : ListPonyViewModel = viewModel()) {
    val poniesState by vm.ponyState.collectAsState()
    LazyColumn {
        poniesState?.let { listBike ->
            items(listBike){ bike ->
                Card(Modifier.padding(16.dp)) {
                    Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Icon(imageVector = Icons.Default.ElectricScooter,
                            contentDescription = "Trotinette")
                        Text("${bike.current_fuel_percent?.times(100)}%")
                        Spacer(Modifier.weight(1f))
                        Text("${bike.current_range_meters?.div(1000)}km")
                        Icon(imageVector = when(bike.current_fuel_percent!!.times(100)) {
                            in (0f..5f) -> Icons.Default.Battery0Bar
                            in (5f..15f) -> Icons.Default.Battery1Bar
                            in (15f..30f) -> Icons.Default.Battery2Bar
                            in (30f..45f) -> Icons.Default.Battery3Bar
                            in (45f..60f) -> Icons.Default.Battery4Bar
                            in (60f..75f) -> Icons.Default.Battery5Bar
                            in (75f..90f) -> Icons.Default.Battery6Bar
                            in (90f..100f) -> Icons.Default.BatteryFull
                            else -> Icons.Default.BatteryAlert
                        }
                        ,
                            contentDescription = "Batterie")
                    }
                }
            }
        }
    }
}