package com.github.jacklt.gae.ktor.tg

import com.github.jacklt.gae.ktor.tg.appengine.telegram.Message
import com.github.jacklt.gae.ktor.tg.appengine.telegram.User
import com.github.jacklt.gae.ktor.tg.data.FireDB

fun main() = startApp()

fun myApp(message: Message): String {
    val input = message.text.orEmpty()
    FireDB.lastMessage = message
    // val name = FireDB.testMap["name"]
    // return "Ciao $input by $name"

    return when (input.toLowerCase()) {
        "film",
        "films",
        "movie" -> showMovieList()
        "diversity",
        "donne",
        "uomini" -> showDiversity()
        "regista",
        "registi",
        "director" -> showDirectors()
        "attore",
        "attrici",
        "attori" -> showActors()
        "chi sono",
        "chi sono?" -> showUser(message.from)
        "sono un bot?" -> showBotUser(message.from)
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

fun showDirectors(): String {
    val directors = movieList.map { it.director }
    val directorsString = directors.joinToString {
        it.name
    }
    val directorsCount = directors.count()
    return "Ci sono $directorsCount registi e i loro nomi sono: $directorsString."
//    return movieList.joinToString("\n") {
//        it.director.name

}

fun showActors(): String {
    val actors = movieList
        .flatMap {
            it.cast
                .filterIsInstance<Actor>()
                .map {
                    val actorSex = when (it.sex) {
                        Sex.MALE -> "♂️"
                        Sex.FEMALE -> "♀️"
                        Sex.NOT_DEFINED -> "\uD83C\uDFF3️\u200D\uD83C\uDF08"
                    }
                    "${it.name} $actorSex"
                }

        }
        .sorted()
        .distinct()

    val actorsCount = actors.count()

    return "Ci sono $actorsCount attori e i loro nomi sono: ${actors.joinToString()}."
//    return movieList.joinToString("\n") {
//        it.director.name

}

fun showUser(user: User?): String {
    return if (user != null) {
        "Ciao ${user.first_name}!"
    } else "ERRORE!!!"
}

fun showBotUser(user: User?): String {
    return if (user?.is_bot == false) {
        "Ciao ${user.first_name}, non sei un bot!"
    } else "ERRORE! Sei un BOT!"
}