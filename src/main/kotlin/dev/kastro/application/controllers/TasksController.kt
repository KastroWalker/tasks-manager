package dev.kastro.application.controllers

import dev.kastro.domain.services.TaskService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/tasks")
class TasksController(
    private val taskService: TaskService,
) {
    @Post
    fun create() {
        taskService.save()
    }
}