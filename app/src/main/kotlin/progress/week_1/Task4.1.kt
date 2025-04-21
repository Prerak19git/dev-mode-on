package org.example.app.progress.week_1

data class User(val name: String, val age: Int)

fun getAdultsNames(users: List<User>): List<String> {

    return users.filter {
        it.age >= 18
    }.map {
        it.name.uppercase()
    }
}

fun main() {
    val users = listOf(
        User("nAmeA", 14),
        User("nAmEb", 24),
        User("nameC", 45),
        User("Named", 12),

        )

    println(getAdultsNames(users).toString())
}
