package org.example.app.progress.week_1

inline fun repeatTaskinline(times: Int, task: () -> Unit) {


    repeat(times) {
        task()
    }
}

inline fun repeatTasknoinline(times: Int, noinline task: () -> Unit) {

    repeat(times) {
        task()
    }
}

inline fun repeatTaskcrossinline(times: Int, crossinline task: () -> Unit) {

    repeat(times) {
        Thread {
            task()
        }.start()
    }
}

fun main() {

    repeatTaskinline(3) {
        println(" I am getting printed - inlined")
//        return
    }
    repeatTasknoinline(3) {
        println(" I am getting printed- noinline")
//        return
    }
    repeatTaskcrossinline(3) {
        println(" I am getting printed-crossinline")
//        return
    }
}