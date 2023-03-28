package dev.kastro.application.controllers

import dev.kastro.application.controllers.requests.TaskRequest
import dev.kastro.application.controllers.responses.TaskResponse
import dev.kastro.domain.services.TaskService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/tasks")
class TasksController(
    private val taskService: TaskService,
) {
    @Post
    fun create(@Body request: TaskRequest): MutableHttpResponse<TaskResponse>? {
        val taskStored = taskService.save(request.toDomain())
        return HttpResponse.created(TaskResponse(taskStored))
    }
}