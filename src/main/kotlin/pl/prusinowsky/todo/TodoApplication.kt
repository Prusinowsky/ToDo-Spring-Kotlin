package pl.prusinowsky.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["pl.prusinowsky.todo"])
class TodoApplication

fun main(args: Array<String>) {
    runApplication<TodoApplication>(*args)
}
