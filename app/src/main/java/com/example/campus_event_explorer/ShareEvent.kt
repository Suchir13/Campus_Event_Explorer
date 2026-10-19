package com.example.campus_event_explorer

import android.content.Context
import android.content.Intent

fun shareEvent(context: Context, event: CampusEvent) {
    // Implicit intent: it names an action (SEND), not a specific app.
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, "${event.title} — ${event.time} — ${event.location}")
    }
    context.startActivity(Intent.createChooser(sendIntent, "Share event"))
}