package com.example.mod4chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable

fun MessageScreen(modifier: Modifier = Modifier,
                  vm : ChatViewModel = viewModel()){
    val state: State<List<Message>> = vm.chatState.collectAsState()
    var message by remember { mutableStateOf("") }
    Column (modifier = modifier) {
        LazyColumn(
            Modifier.weight(
                1f,
                true
            )
        ) {
            items(state.value) { message ->
                Column {
                    ElevatedCard(Modifier.padding(8.dp)) {
                        Text(
                            message.message,
                            Modifier.padding(8.dp)
                        )
                    }
                    Text (
                            message.user,
                        Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
        Row (Modifier.fillMaxWidth()) {
            TextField(
                value = message,
                onValueChange = { message = it },
                Modifier.weight(1f, true),
                label = { Text("Message") },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            vm.sendMessage(Message(message = message))
                            message = ""
                      },
                        Modifier.width(IntrinsicSize.Min)
                    ) {
                        Icon(imageVector = Icons.Filled.Send, contentDescription = null) }
                })
        }
    }
}