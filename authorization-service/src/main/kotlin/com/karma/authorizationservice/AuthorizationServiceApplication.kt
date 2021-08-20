package com.karma.authorizationservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
class AuthorizationServiceApplication

fun main(args: Array<String>) {
	runApplication<AuthorizationServiceApplication>(*args)
}
