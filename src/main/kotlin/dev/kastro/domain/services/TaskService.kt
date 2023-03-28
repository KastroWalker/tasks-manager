package dev.kastro.domain.services

import dev.kastro.domain.models.Task
import dev.kastro.domain.repositories.TaskRepository
import jakarta.inject.Singleton

@Singleton
class TaskService(
    private val taskRepository: TaskRepository,
) {
    fun save() {
        val task = Task(
            title = "Create board",
            description = "Create a new board to manage tasks",
            done = false
        )
        taskRepository.save(task)
    }
}
