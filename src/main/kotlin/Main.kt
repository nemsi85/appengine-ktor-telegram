package com.github.jacklt.gae.ktor.tg

fun main() = startApp()

var old: Int? = null

fun myApp(input: String): String {
    val addendo1: Int? = input.toIntOrNull()
    if (addendo1 != null) {
        if (old != null) {
            val risultato: Int = old!! + addendo1
          old = null
            return "Il tuo risultato è $risultato"
        } else {
            old = addendo1
            return "Inserisci il secondo numero"
        }
    } else {
        return "Il tuo input non è valido"
    }
}