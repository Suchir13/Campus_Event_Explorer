package com.example.campus_event_explorer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Owns the search state and derives the filtered list from it.
@Composable
fun EventListRoute(onEventSelected: (Long) -> Unit) {
    var query by rememberSaveable { mutableStateOf("") }

    // Derived from query on every recomposition, not a separate mutable list.
    val filteredEvents = campusEvents.filter {
        it.title.contains(query, ignoreCase = true) ||
                it.category.contains(query, ignoreCase = true)
    }

    EventListScreen(
        events = filteredEvents,
        query = query,
        onQueryChange = { query = it },
        onEventSelected = onEventSelected
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    events: List<CampusEvent>,
    query: String,
    onQueryChange: (String) -> Unit,
    onEventSelected: (Long) -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Campus Events") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                label = { Text("Search events") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(events, key = { it.id }) { event ->
                    EventCard(
                        event = event,
                        onClick = { onEventSelected(event.id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun EventCard(event: CampusEvent, onClick: () -> Unit) {
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.title, style = MaterialTheme.typography.titleMedium)
            Text(text = event.category, style = MaterialTheme.typography.labelLarge)
            Text(text = event.location)
            Text(text = event.time)
        }
    }
}