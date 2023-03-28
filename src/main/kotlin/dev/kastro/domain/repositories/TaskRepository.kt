package dev.kastro.domain.repositories

import dev.kastro.domain.models.Task
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TaskRepository : CrudRepository<Task, Long>