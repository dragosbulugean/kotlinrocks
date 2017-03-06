package com.kotlinrocks

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class App {

    private val log = LoggerFactory.getLogger(App::class.java)

    @Bean
    fun init(repo: UserRepo) = CommandLineRunner {

        repo.save(User("Jack", "Bauer"))
        repo.save(User("Chloe", "O'Brian"))
        repo.save(User("Kim", "Bauer"))
        repo.save(User("David", "Palmer"))
        repo.save(User("Michelle", "Dessler"))
        log.info("Inserted users:")
        for (user in repo.findAll()) {
            log.info(user.toString())
        }
        log.info("")

    }

}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}
