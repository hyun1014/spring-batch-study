package com.example.springbatchstudy

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableBatchProcessing
@EnableJpaRepositories
@SpringBootApplication
class SpringBatchStudyApplication

fun main(args: Array<String>) {
    runApplication<SpringBatchStudyApplication>(*args)
}
