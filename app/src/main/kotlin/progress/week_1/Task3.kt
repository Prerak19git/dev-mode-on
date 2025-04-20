package org.example.app.progress.week_1

typealias ID = Int

interface LoggedInUserActions {

    fun changeName(newName: String)
}

interface LoggedOutUserActions {
    fun logIn(userName: String, id: ID)
}


object MyApp {

    private var users = mutableMapOf<User, ID>()

    sealed class User(open val userName: String) {
        data class BannedUser(override val userName: String) : User(userName)
        data class LoggedOutUser(override val userName: String) : User(userName), LoggedOutUserActions {
            override fun logIn(userName: String, id: ID) {
                val existingUser = users.keys.find {
                    it.userName == userName
                }
                when (existingUser) {
                    is BannedUser -> println("You are banned , dear $userName")
                    is LoggedInUser -> println("You are already loggedIn , dear $userName")
                    is LoggedOutUser -> {
                        println("Logging you in....")
                        users.remove(existingUser)
                        users[LoggedInUser(userName, id)] = id
                    }

                    null -> println("Pardon you dont exist in my database")
                }
            }
        }

        data class LoggedInUser(override val userName: String, val id: ID) : User(userName), LoggedInUserActions {

            override fun changeName(newName: String) {
                val existingUser = users.keys.find {
                    it.userName == userName
                }
                if (existingUser is LoggedInUser) {
                    users.remove(existingUser)
                    users[LoggedInUser(newName, id)] = id
                    println("Surely ! your name has been changed.")
                }
            }
        }
    }


    fun createUser(userName: String): User {
        val existingUser = users.keys.find {
            it.userName == userName
        }
        existingUser?.let {
            println("username already exists returning the same user")
            return it
        }

        val newID = (users.values.maxOrNull() ?: 0) + 1

        println("created new user with id : $newID")
        users[User.LoggedInUser(userName, newID)] = newID
        return User.LoggedInUser(userName, newID)
    }

    fun getUser(userName: String, id: ID) {
        val existingUser = users.keys.find {
            it.userName == userName
        }
        when (existingUser) {
            is User.BannedUser -> {
                println(" You are banned already!.")
            }

            is User.LoggedInUser -> {
                if (existingUser.id != id) {
                    users.remove(existingUser)
                    users[User.BannedUser(userName)] = id
                    println("You have been banned")
                } else {
                    println("You are logged in already, dear ${existingUser.userName}")
                }
            }

            is User.LoggedOutUser -> {
                println("You are a user but you are logged out.")
            }

            null -> {
                println("Pardon you don't exist.")
            }
        }
    }

}