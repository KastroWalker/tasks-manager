package dev.kastro.domain.services

import dev.kastro.domain.models.Task
import dev.kastro.domain.repositories.TaskRepository
import jakarta.inject.Singleton

@Singleton
class TaskService(
    private val taskRepository: TaskRepository,
) {
    fun save(task: Task): Task {
        return taskRepository.save(task)
    }
}
