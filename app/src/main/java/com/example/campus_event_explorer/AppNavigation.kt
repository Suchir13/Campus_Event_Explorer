package com.example.campus_event_explorer

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun CampusEventApp() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = EventList) {
        composable<EventList> {
            EventListRoute(
                onEventSelected = { id -> navController.navigate(EventDetail(eventId = id)) }
            )
        }
        composable<EventDetail> { backStackEntry ->
            val route = backStackEntry.toRoute<EventDetail>()
            // Only the id travels in the route; the event is looked up here.
            val event = campusEvents.firstOrNull { it.id == route.eventId }

            EventDetailScreen(
                event = event,
                onBack = { navController.popBackStack() },
                onShare = { event?.let { shareEvent(context, it) } }
            )
        }
    }
}