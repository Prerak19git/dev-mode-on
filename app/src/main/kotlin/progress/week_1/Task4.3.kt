package org.example.app.progress.week_1

data class UserWithEmail(val id: Int, val name: String, val email: String)


fun getUserEmailDirectory(users: List<UserWithEmail>): Map<Int, String> {
    return users.distinctBy {
        it.email
    }.associate {
        it.id to it.name
    }
}

fun main() {
    val users = listOf(
        UserWithEmail(1, "Alice", "alice@email.com"),
        UserWithEmail(2, "Bob", "bob@email.com"),
        UserWithEmail(3, "Charlie", "alice@email.com"),
        UserWithEmail(4, "David", "david@email.com"),
        UserWithEmail(5, "Eve", "eve@email.com"),
        UserWithEmail(6, "Frank", "bob@email.com")
    )
println(getUserEmailDirectory(users).toString())
}
