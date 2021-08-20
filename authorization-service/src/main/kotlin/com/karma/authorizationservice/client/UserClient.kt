package com.karma.authorizationservice.client

import com.karma.authorizationservice.dto.UserDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "usermanagement-service", url = "localhost:9002")
interface UserClient {

    @GetMapping
    fun getUserByUsername(username: String): UserDto
}
