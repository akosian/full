package com.karma.usermanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
class UserManagementServiceApplication

fun main(args: Array<String>) {
    runApplication<UserManagementServiceApplication>(*args)
}

@Bean
fun encoder() = BCryptPasswordEncoder()
