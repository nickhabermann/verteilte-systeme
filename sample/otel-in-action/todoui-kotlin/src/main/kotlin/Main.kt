package io.novatec.todoui

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.client.RestTemplate
import javax.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@SpringBootApplication
@Controller
class TodouiApplication {

    private val logger: Logger = LoggerFactory.getLogger(TodouiApplication::class.java)

    @Value("\${backend.url}")
    lateinit var endpoint: String
    private val template = RestTemplate()

    @PostConstruct
    fun postConstruct() {
        logger.info(" UI initialized for backend at $endpoint")
    }

    @GetMapping
    fun getItems(model: Model): String {
        logger.info("GET $endpoint/todos/")
        val response: ResponseEntity<Array<String>> = template.getForEntity("$endpoint/todos/", Array<String>::class.java)
        response.body?.let {
            model.addAttribute("items", it)
        }
        return "items"
    }

    @PostMapping
    fun addItem(toDo: String): String {
        logger.info("POST $endpoint/todos/$toDo")
        template.postForEntity("$endpoint/todos/$toDo", null, String::class.java)
        return "redirect:/"
    }

    @PostMapping("{toDo}")
    fun setItemDone(@PathVariable toDo: String): String {
        logger.info("POST $endpoint/todos/$toDo")
        template.delete("$endpoint/todos/$toDo")
        return "redirect:/"
    }
}

fun main(args: Array<String>) {
    runApplication<TodouiApplication>(*args)
}
