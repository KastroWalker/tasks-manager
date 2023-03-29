package dev.kastro.application.controllers

import dev.kastro.application.controllers.requests.TaskRequest
import dev.kastro.application.controllers.responses.TaskResponse
import dev.kastro.domain.models.Task
import dev.kastro.domain.services.TaskService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import java.util.Optional

@Controller("/tasks")
class TasksController(
    private val taskService: TaskService,
) {
    @Post
    fun create(@Body request: TaskRequest): MutableHttpResponse<TaskResponse>? {
        val taskStored = taskService.save(request.toDomain())
        return HttpResponse.created(TaskResponse(taskStored))
    }

    @Get
    fun list(@QueryValue done: Optional<Boolean>): MutableHttpResponse<List<TaskResponse>>? {
        val taskList: MutableIterable<Task> = if (done.isPresent) {
            taskService.listByDone(done.get())
        } else {
            taskService.list()
        }

        return HttpResponse.ok(taskList.map { TaskResponse(it) })
    }
}