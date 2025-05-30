package org.example.app.week_3.progress

inline fun perform(action: () -> Unit, crossinline reaction: () -> Unit) {
    println("Before action")
    action()
    println("After action")
    reaction()

}

inline fun withTimings(noinline block: () -> Unit){
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("Took ${end- start} milli seconds")
}

fun main() {
    withTimings {
        repeat(1000000){
            println("_hello for the $it time")
        }
    }
}