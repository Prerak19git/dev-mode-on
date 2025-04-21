

package org.example.app.progress.week_1

 data class CityUser(val name: String, val age: Int, val city: String)

fun getAdultsGroupedByCity(users: List<CityUser>): Map<String, List<String>> {

    return users.groupBy {
        it.city
    }.mapValues { entry ->
        entry.value.filter { entryUser ->
            entryUser.age >= 18
        }.map {
            it.name.uppercase()
        }
    }

}


fun main() {
    val users = listOf(
        CityUser("alice", 17, "Delhi"),
        CityUser("bob", 21, "Mumbai"),
        CityUser("charlie", 19, "Delhi"),
        CityUser("david", 15, "Mumbai"),
        CityUser("ella", 22, "Chennai"),
    )

    println(getAdultsGroupedByCity(users).toString())


}