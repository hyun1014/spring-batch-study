package com.example.springbatchstudy.job

import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SimpleJobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Bean
    fun simpleJob(): Job {
        return jobBuilderFactory.get("simpleJob")
            .start(simpleStep())
            .build()
    }

    @Bean
    @JobScope
    fun simpleStep(): Step {
        return stepBuilderFactory.get("simpleStep")
            .tasklet{ contribution, chunkContext ->
                log.info("tasklet done")
                RepeatStatus.FINISHED
            }
            .build()
    }
}