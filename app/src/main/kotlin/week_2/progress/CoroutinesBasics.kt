package org.example.app.week_2.progress

import kotlinx.coroutines.*


fun main(): Unit = runBlocking {

    coroutineScope {
        launch() {
            println(
                "Starting coroutine-1 in ${Thread.currentThread().name} with id as ${
                    Thread.currentThread().threadId()
                }"
            )

            delay(500)
            println("completing the coroutine-1")
        }

        launch() {
            println(
                "Starting coroutine-2 in ${Thread.currentThread().name} with id as ${
                    Thread.currentThread().threadId()
                }"
            )

            delay(1000)
            println("completing the coroutine-2")
        }

        launch() {
            println(
                "Starting coroutine-3 in ${Thread.currentThread().name} with id as ${
                    Thread.currentThread().threadId()
                }"
            )

            delay(1500)
            println("completing the coroutine-3")
        }

    }
    println(
        "completing the runblocking parent which was runnning on ${Thread.currentThread().name} and id ${
            Thread.currentThread().threadId()
        }"
    )
}