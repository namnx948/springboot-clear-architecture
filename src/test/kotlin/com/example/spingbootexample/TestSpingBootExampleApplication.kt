package com.example.spingbootexample

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<SpingBootExampleApplication>().with(TestcontainersConfiguration::class).run(*args)
}
