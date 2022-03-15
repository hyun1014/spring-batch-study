package com.example.springbatchstudy.controller

import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameter
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dev")
class HomeController(
    private val jobLauncher: JobLauncher,
    private val simpleJob: Job
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("")
    fun hello() = "hello"

    @GetMapping("/runJob")
    fun runJob(@RequestParam params: Map<String, String>?) {
        val jobParameterMap = params?.entries?.associate { it.key to JobParameter(it.value) } ?: mutableMapOf()
        val jobParameters = JobParameters(jobParameterMap as MutableMap<String, JobParameter>)
        jobLauncher.run(simpleJob, jobParameters)
    }
}