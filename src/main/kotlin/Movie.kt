package com.github.jacklt.gae.ktor.tg

data class Movie(
    val title: String,
    val director: Director,
    val year: Int,
    val genre: Genre,
    val pg: List<Cast>
)

interface Cast{
    val name: String
}
interface Persona {
    val sex: Sex
}

data class Director(val name: String, override val sex: Sex) : Persona

enum class Sex(val ita: String) {
    MALE("maschio"),
    FEMALE("femmina"),
    NOT_DEFINED("non specificato")
}

enum class Genre {
    HORROR, ROMANTICO, COMMEDIA, DRAMA
}

data class Actor(override val name: String, override val sex: Sex, val role: String) : Cast, Persona
data class Robot(override val name: String, val role: String) : Cast
