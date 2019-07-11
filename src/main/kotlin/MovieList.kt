package com.github.jacklt.gae.ktor.tg

val movieList = listOf(
    Movie(
        "Bastardi senza gloria",
        Director("Tarantino", Sex.MALE),
        2007,
        Genre.DRAMA,
        listOf(
            Actor("Brad Pitt", Sex.MALE, "Protagonista"),
            Actor("Christopher Waltz", Sex.MALE, role = "Cattivo"),
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
            Actor("Rupert Grint", Sex.NOT_DEFINED, role = "Idiota"),
            Actor("Emma Watson", Sex.FEMALE, role = "La salvezza dei 2 cretini"),
            Robot("Voldemort", "Doppiogiochista"),
            Actor("Brie Larson", Sex.FEMALE, "Protagonista")
        )
    ),
    Movie(
        "Capitan Marvel",
        Director("Anna Boden", Sex.FEMALE),
        2018,
        Genre.ROMANTICO,
        listOf(
            Actor("Brie Larson", Sex.FEMALE, "Protagonista"),
            Actor("Samuel L Jackson", Sex.MALE, role = "Lo Shield"),
            Actor("Ben Stiller", Sex.MALE, role = "Cattivo"),
            Robot("Goose", "La star")
        )
    )
)