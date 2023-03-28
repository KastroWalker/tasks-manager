package dev.kastro.application.controllers.responses

import dev.kastro.domain.models.Task

data class TaskResponse(
    val id: Long,
    val title: String,
    val description: String,
    val done: Boolean
) {
    constructor(task: Task) : this(task.id!!, task.title, task.description, task.done)
}