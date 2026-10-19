package com.example.campus_event_explorer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    event: CampusEvent?,
    onBack: () -> Unit,
    onShare: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Event details") },
                navigationIcon = {
                    // Up button: asks the caller to go back.
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Navigate up"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (event == null) {
            // Invalid id: show a message instead of crashing.
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(24.dp)
            ) {
                Text(text = "Event unavailable", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onBack) { Text("Return to events") }
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = event.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Category: ${event.category}")
                Text(text = "Date/time: ${event.time}")
                Text(text = "Location: ${event.location}")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = event.description)
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = onShare) { Text("Share event") }
            }
        }
    }
}