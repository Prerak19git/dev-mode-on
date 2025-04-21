package org.example.app.progress.week_1


fun getAdultsNamesGroupedByCity(users: List<CityUser>): Map<String, String> {

    return users.groupBy {
        it.city
    }.mapValues { entry ->
        entry.value.filter { entryUser ->
            entryUser.age >= 18
        }.joinToString(",") {
            it.name
        }
    }
}


fun main() {
    val users = listOf(
        CityUser("Alice", 24, "Delhi"),
        CityUser("Bob", 21, "Mumbai"),
        CityUser("Charlie", 19, "Delhi"),
        CityUser("David", 17, "Mumbai"),
        CityUser("Ella", 22, "Chennai")
    )

    println(getAdultsNamesGroupedByCity(users).toString())

}