package com.github.jacklt.gae.ktor.tg

fun main() = startApp()

fun myApp(input: String): String {
    return when (input.toLowerCase()) {
        "film",
        "films",
        "movie" -> showMovieList()
        "diversity",
        "donne",
        "uomini" -> showDiversity()
        else -> "Il tuo comando non è corretto"
    }
}

fun showMovieList(): String {
    val titleList = movieList.joinToString("\n") {
        val actorList = it.cast.joinToString { it.name }
        "${it.title}:\n * $actorList"
    }
    return "Questo è l'elenco dei film\n$titleList"
}

fun showDiversity(): String {
    return movieList.joinToString("\n") {
        val listPersona: List<Persona> = it.cast.filterIsInstance<Persona>() + it.director
        val femPersona = listPersona.filter { it.sex == Sex.FEMALE }.count()
        val malePersona = listPersona.filter { it.sex == Sex.MALE }.count()
       "In ${it.title} sono presenti $femPersona donne e $malePersona uomini"
    }

}
