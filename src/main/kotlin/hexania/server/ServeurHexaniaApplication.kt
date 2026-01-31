package hexania.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServeurHexaniaApplication

fun main(args: Array<String>) {
	runApplication<ServeurHexaniaApplication>(*args)
}
