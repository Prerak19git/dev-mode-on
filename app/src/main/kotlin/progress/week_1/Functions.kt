package org.example.app.progress.week_1


enum class Operation {
    SQUARE,
    CUBE;
}

fun performOperation(number: Int, operation: Operation): Int {
    return when (operation) {
        Operation.SQUARE -> {
            number * number
        }

        Operation.CUBE -> {
            number * number * number
        }
    }
}

fun greet(personToGreet: String = "Prerak") {
    println("Hi there, I am here to greet you!  Welcome $personToGreet")
}

fun printTheNumbers(vararg numbers: String) {
    numbers.forEach {
        print("$it ")
    }
    println()
}

fun oneLiner() = println("I am just a simple one liner function")


fun main() {

    greet()
    greet("Drake")
    println(performOperation(25, Operation.SQUARE))
    println(performOperation(25, Operation.CUBE))
    printTheNumbers("1", "2", "4", "5")
    oneLiner()

}