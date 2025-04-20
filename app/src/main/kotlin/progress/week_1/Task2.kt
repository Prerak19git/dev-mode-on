package org.example.app.progress.week_1

import org.example.app.progress.week_1.Status.Companion.toResult

typealias Data = String

sealed interface Result {

    data class Success(val data: Data) : Result
    data class Error(val code: Int) : Result
    data object Loading : Result
    data object Empty : Result

}

enum class Status {
    Pending,
    InProgress,
    Failed,
    Done;

    companion object {
        fun Status.toResult(): Result =
            when (this) {
                Pending -> Result.Empty
                InProgress -> Result.Loading
                Failed -> Result.Error(404)
                Done -> Result.Success("I am fetched successfully")
            }

    }

}

data class Job(
    val jobId: Int,
    val status: Status
)

fun main() {
    val jobs = listOf(
        Job(1, Status.Pending),
        Job(2, Status.InProgress),
        Job(3, Status.Failed),
        Job(4, Status.Done)
    )
    jobs.forEach {
        when (it.status) {
            Status.Pending -> {
                println("${it.jobId} has the status as ${it.status.toResult()}")
            }

            Status.InProgress -> {
                println("${it.jobId} has the status as ${it.status.toResult()}")
            }

            Status.Failed -> println("${it.jobId} has the status as ${it.status.toResult()}")
            Status.Done -> println("${it.jobId} has the status as ${it.status.toResult()}")
        }
    }
}
