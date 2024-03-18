package com.example.mod2filmserie

// clé -> Film/série
// valeur -> DéjàVu/Avoir
val mapFilmSerie = mutableMapOf("Iron Man 1" to false)
fun displayMenu(){
    println("Choisissez")
    println("1 - Ajouter un film déjà vu")
    println("2 - Ajouter un film à voir")
    println("3 - Voir tout")
    println("4 - Exit")
}
fun addMovieAlreadySeen(){
    println("Nom du film/série")
    mapFilmSerie[readln()] = true
}
fun addMovieToWatch(){
    println("Nom du film/série")
    mapFilmSerie[readln()] = false
}
fun listFilmSerie(){
    mapFilmSerie.forEach{ (film, dejaVu) ->
        val dejaVuPrint = "a déjà été vu"
        val aVoirPrint = "est à voir"
        println("Le film $film ${if (dejaVu) dejaVuPrint else aVoirPrint}")
    }
}

fun main() {
    var userInput :String?
    do {
        displayMenu()
        userInput= readln()
        when(userInput){
            "1" -> addMovieAlreadySeen()
            "2" -> addMovieToWatch()
            "3" -> listFilmSerie()
        }
    }while (userInput != "4")
}