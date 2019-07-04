package com.github.jacklt.gae.ktor.tg

val movieList = listOf(
    Movie(
        "Bastardi senza gloria",
        Director("Tarantino", Sex.MALE),
        2007,
        Genre.DRAMA,
        listOf(
            Actor("Brad Pitt", Sex.MALE, "Protagonista"),
            Actor("Waltz", Sex.MALE, role = "Cattivo"),
            Actor("Fassy", Sex.MALE, role = "Infiltrato")
        )
    ),
    Movie(
        "Harry Potter",
        Director("Columbus", Sex.MALE),
        2001,
        Genre.COMMEDIA,
        listOf(
            Actor("Radcliffe", Sex.MALE, "Protagonista"),
            Actor("Grint", Sex.MALE, role = "Idiota"),
            Actor("Watson", Sex.FEMALE, role = "La salvezza dei 2 cretini"),
            Robot("Voldemort", "Doppiogiochista")
        )
    ),
    Movie(
        "Capitan Marvel",
        Director("Anna Boden", Sex.FEMALE),
        2018,
        Genre.ROMANTICO,
        listOf(
            Actor("Larson", Sex.FEMALE, "Protagonista"),
            Actor("Samuel L Jackson", Sex.MALE, role = "Lo Shield"),
            Actor("Ben", Sex.MALE, role = "Cattivo"),
            Robot("Goose", "La star")
        )
    )
)