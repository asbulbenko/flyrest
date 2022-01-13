package com.buas.flyrest.service

import com.buas.flyrest.model.Task
import com.buas.flyrest.repository.TaskRepository
import org.springframework.data.domain.Example
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TaskService(private val taskRepository: TaskRepository) {

    fun getTasks(): List<Task> = taskRepository.findAll()

    fun addTask(task: Task): ResponseEntity<Task> =
        ResponseEntity.ok(taskRepository.save(task))

    fun getTaskById(taskId: Long): ResponseEntity<Task> =
        taskRepository.findById(taskId).map { task ->
            ResponseEntity.ok(task)
        }.orElse(ResponseEntity.notFound().build())

    fun getTaskByTitle(title: String): ResponseEntity<Task> {
        val tasks: List<Task> = taskRepository.findByTitle(title)
        return if (tasks.isEmpty()) ResponseEntity.notFound().build()
        else ResponseEntity.ok(tasks[0])
    }

    fun putTask(taskId: Long, newTask: Task): ResponseEntity<Task> =
        taskRepository.findById(taskId).map { currentTask ->
            val updatedTask: Task =
                currentTask.copy(
                    title = newTask.title,
                    description = newTask.description,
                    status = newTask.status,
                    start_date = newTask.start_date,
                    priority = newTask.priority,
                    due_date = newTask.due_date
                )
            ResponseEntity.ok().body(taskRepository.save(updatedTask))
        }.orElse(ResponseEntity.notFound().build())

    fun deleteTask(taskId: Long): ResponseEntity<Void> =
        taskRepository.findById(taskId).map { task ->
            taskRepository.delete(task)
            ResponseEntity<Void>(HttpStatus.ACCEPTED)
        }.orElse(ResponseEntity.notFound().build())
}