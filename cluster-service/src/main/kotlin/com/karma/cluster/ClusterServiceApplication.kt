package com.karma.cluster

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
class ClusterApplication

fun main(args: Array<String>) {
    runApplication<ClusterApplication>(*args)
}
