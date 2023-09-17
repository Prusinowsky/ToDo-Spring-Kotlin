package pl.prusinowsky.todo.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pl.prusinowsky.todo.model.Task


@Repository
interface TaskRepository : CrudRepository<Task, Long>