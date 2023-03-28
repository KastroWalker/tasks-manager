package dev.kastro.application.controllers.requests

import dev.kastro.domain.models.Task

data class TaskRequest(
    val title: String,
    val description: String,
    val done: Boolean = false
) {
    fun toDomain(): Task = Task(
        title = title,
        description = description,
        done = done
    )
}