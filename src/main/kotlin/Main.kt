package com.github.jacklt.gae.ktor.tg

fun main() = startApp()

fun myApp(input: String): String {
    return when (input.toLowerCase()) {
        "film",
        "films" -> movieList()
        else -> "Il tuo comando non è corretto"
    }
}

fun movieList(): String {
    val titleList = movieList.joinToString("\n") {
        val actorList = it.pg.joinToString { it.name }
        "${it.title}:\n * $actorList"
    }
    return "Questo è l'elenco dei film\n$titleList"
}

