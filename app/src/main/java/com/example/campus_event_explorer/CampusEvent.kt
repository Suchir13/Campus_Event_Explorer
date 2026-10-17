package com.example.campus_event_explorer

data class CampusEvent(
    val id: Long,
    val title: String,
    val category: String,
    val location: String,
    val time: String,
    val description: String
)

val campusEvents = listOf(
    CampusEvent(1L, "Mobile Development Meetup", "Tech", "CAS 214", "Tuesday 6:30 PM",
        "Swap tips on Kotlin and Jetpack Compose and get feedback on side projects from other student developers."),
    CampusEvent(2L, "Resume Review Night", "Career", "Career Center", "Wednesday 5:00 PM",
        "Bring a printed resume and get quick feedback from alumni working in software and data roles."),
    CampusEvent(3L, "Charles River Sunset Walk", "Social", "Esplanade Entrance", "Friday 5:30 PM",
        "An easy group walk along the river to end the week and meet people outside your program."),
    CampusEvent(4L, "Intro to Machine Learning Workshop", "Tech", "CDS 365", "Thursday 4:00 PM",
        "A hands-on session that trains a small classifier from scratch. Bring a laptop; no experience needed."),
    CampusEvent(5L, "Open Mic Night", "Arts", "Student Union Ballroom", "Saturday 7:00 PM",
        "Music, poetry, and stand-up from students. Sign up at the door to perform or just come to watch."),
    CampusEvent(6L, "Pickup Soccer", "Sports", "Nickerson Field", "Sunday 10:00 AM",
        "Casual mixed-skill games with no registration. Wear cleats if you have them."),
    CampusEvent(7L, "Mindfulness Break", "Wellness", "Health Center Lawn", "Monday 12:30 PM",
        "Thirty minutes of guided breathing and stretching to reset between classes."),
    CampusEvent(8L, "Hackathon Kickoff", "Tech", "Questrom Atrium", "Friday 6:00 PM",
        "Meet teammates, hear the challenge themes, and pitch ideas before the weekend build starts."),
    CampusEvent(9L, "Alumni Networking Mixer", "Career", "Metcalf Hall", "Wednesday 6:30 PM",
        "Talk with recent graduates about breaking into the industry over snacks."),
    CampusEvent(10L, "Documentary Film Night", "Arts", "CAS 226", "Thursday 8:00 PM",
        "A screening followed by an open discussion with the student film club.")
)