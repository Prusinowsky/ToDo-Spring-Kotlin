package pl.prusinowsky.todo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import pl.prusinowsky.todo.model.Task
import pl.prusinowsky.todo.repository.TaskRepository

@RestController
@RequestMapping("/tasks")
class TaskController @Autowired constructor(private val taskRepository: TaskRepository) {

    @GetMapping("/")
    fun getTasks(): Iterable<Task> {
        return taskRepository.findAll()
    }

    @PostMapping("/")
    fun createTask(@RequestBody task: Task): Task {
        return taskRepository.save(task)
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Long): Task {
        return taskRepository.findById(id).orElseThrow { NoSuchElementException("Task not found") }
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody updatedTask: Task): Task {
        val existingTask = taskRepository
            .findById(id)
            .orElseThrow { NoSuchElementException("Task not found") }

        return taskRepository.save(
            existingTask.copy(
                title = updatedTask.title,
                completed = updatedTask.completed
            )
        )
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long) {
        val task = taskRepository.findById(id).orElseThrow { NoSuchElementException("Task not found") }
        taskRepository.delete(task)
    }
}