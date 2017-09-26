package io.pivotal.moduleskt

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ModulesktApplication

fun main(args: Array<String>) {
    SpringApplication.run(ModulesktApplication::class.java, *args)
}
